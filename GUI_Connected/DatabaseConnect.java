import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnect {
		public static String isClosed;
		private Connection connect;
		
		public void ConnectToDB() {
			try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
				String DBurl 	= "jdbc:mysql://localhost/bank3c_final";
				String user 	= "JavaApp";
				String pass 	= "TheBestAnAppCanGet";
				connect = DriverManager.getConnection(DBurl, user, pass);
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		
		// true is when the connection is closed
		public boolean CheckConn() throws SQLException{
		    return connect.isClosed();
		}

		// Checks if the cardUID or iBan is known
		public boolean checkCard(String givenCard) throws SQLException{
			if(givenCard.length() >= 15){
				return checkIban(givenCard);
			} else if(givenCard.length() == 11){
				return checkCuid(givenCard);
			}
			System.err.println("Error, card not known");
			return false;
		}

		// checks in DB if the uid of given card is known
		private boolean checkCuid(String CardUID) throws SQLException{
			PreparedStatement UidStatement = connect.prepareStatement("Select EXISTS(Select * FROM rekening where cardUID = ?)");
			UidStatement.setString(1, CardUID);
			ResultSet UidResultSet = UidStatement.executeQuery();
			UidResultSet.next();
			if(!UidResultSet.getBoolean(1)) System.err.println("UID is not known!");
			return UidResultSet.getBoolean(1);
		}

		// checks if iBan is known
		private boolean checkIban(String iBan) throws SQLException{
			PreparedStatement iBanStatement = connect.prepareStatement("Select EXISTS(Select * FROM rekening where iBan = ?)");
			iBanStatement.setString(1, iBan);
			ResultSet iBanResultSet = iBanStatement.executeQuery();
			iBanResultSet.next();
			if(!iBanResultSet.getBoolean(1)) System.err.println("iBan is not known!");
			return iBanResultSet.getBoolean(1);
		}

		// returns iBan if uid is known, otherwise it returns NULL
		private String getIban(String givenCard) throws SQLException{
			if(givenCard.length() > 11 && checkIban(givenCard)) return givenCard;
			if(!checkCuid(givenCard)) return null;

			PreparedStatement iBanStatement = connect.prepareStatement("Select iBan FROM rekening where cardUID = ?");
			iBanStatement.setString(1, givenCard);
			ResultSet iBanResultSet = iBanStatement.executeQuery();
			iBanResultSet.next();
			return iBanResultSet.getString(1);
		}	
		
		// updates the DB when the pin is not correct
		private void attemptFailed(String iBan) throws SQLException{	
			System.err.println("Pin is not Correct!");
			PreparedStatement attempsStatement = connect.prepareStatement("UPDATE rekening SET attemps = ? where iBan = ?");
			attempsStatement.setInt(1, checkAttemps(getIban(iBan))-1);
			attempsStatement.setString(2, getIban(iBan));
			attempsStatement.executeUpdate();
		}
		
		// updates the DB when the pis is correct
		private void attemptCorrect(String iBan) throws SQLException{	
			PreparedStatement attempsStatement = connect.prepareStatement("UPDATE rekening SET attemps = 3 where iBan = ?");
			attempsStatement.setString(1, getIban(iBan));
			attempsStatement.executeUpdate();
		}
		
		// checks how many attemps the given card has 
		public int checkAttemps(String iBan) throws SQLException{
			if(!checkCard(iBan)) return -1;
			PreparedStatement attempsStatement = connect.prepareStatement("Select attemps FROM rekening where iBan = ?");
			attempsStatement.setString(1, getIban(iBan));
			ResultSet attempsResultSet = attempsStatement.executeQuery();
			attempsResultSet.next();
			return attempsResultSet.getInt(1);
		}
		
		// returns true when the card is blocked
		public boolean isBlocked(String iBan) throws SQLException{
			if(!checkCard(iBan)) return true;
			PreparedStatement attempsStatement = connect.prepareStatement("Select attemps FROM rekening where iBan = ?");
			attempsStatement.setString(1, getIban(iBan));
			ResultSet attempsResultSet = attempsStatement.executeQuery();
			attempsResultSet.next();
			if(attempsResultSet.getInt(1) <= 0) return true;
			return false;
		}
		
		// if pin is correct, attemps is set to 3 and return true, or false with attemps - 1
		public boolean checkPin(String iBan, String clearPin) throws SQLException{
			if(isBlocked(iBan)) return false;
			PreparedStatement pinStatement = connect.prepareStatement("SELECT PIN FROM rekening WHERE iBan = ?");
			pinStatement.setString(1, getIban(iBan));
			ResultSet pinResultSet = pinStatement.executeQuery();
			pinResultSet.next();
			if(pinResultSet.getString(1).equals(clearPin)) {
				attemptCorrect(iBan);
				return true;
			}
			attemptFailed(iBan);
			return false;
		}
		
		// if the pin is correct give the correct balance
		public float getBalance(String iBan, boolean pinOK) throws SQLException {
			if(!pinOK) return -1;
			PreparedStatement balanceStatement = connect.prepareStatement("Select saldo FROM rekening where iBan = ?");
			balanceStatement.setString(1, getIban(iBan));
			ResultSet balanceResultSet = balanceStatement.executeQuery();
			balanceResultSet.next();
			return balanceResultSet.getFloat(1);
		}
		
		// if the pin is correct and there is enough money
		public boolean withdraw(String iBan, double withdrawAmount, boolean pinOK) throws SQLException{
			if(getBalance(iBan, pinOK) >= withdrawAmount) {
				PreparedStatement withdrawStatement = connect.prepareStatement("UPDATE rekening SET saldo = (saldo - ?) where iBan = ?");
				withdrawStatement.setDouble(1, withdrawAmount);
				withdrawStatement.setString(2, getIban(iBan));
				withdrawStatement.executeUpdate();
				return true;
			}
			return false;
		}
		
		/*
		 Extra features wat die (nog) niet nodig zijn
		 
		 public void updateAttemps(String CardUID, int updateAttemps) throws SQLException{
			PreparedStatement attempsStatement = connect.prepareStatement("UPDATE rekening SET attemps = ? where cardUID = ?");
			attempsStatement.setInt(1, updateAttemps);
			attempsStatement.setString(2, CardUID);
			attempsStatement.executeUpdate();
		}
		
		private static Object hashPin(Object x) {
			return x.hashCode();
		}		
		
		public boolean checkHashedPin(String CardUID, String clearPin) throws SQLException{
			PreparedStatement saltStatement = connect.prepareStatement("SELECT salt FROM rekening WHERE cardUID = ?");
			saltStatement.setString(1, CardUID);
			ResultSet saltResultSet = saltStatement.executeQuery();
			saltResultSet.next();
			
			PreparedStatement hashedPinStatement = connect.prepareStatement("SELECT hashedPIN FROM rekening WHERE cardUID = ?");
			hashedPinStatement.setString(1, CardUID);
			ResultSet hashedPinResultSet = hashedPinStatement.executeQuery();
			hashedPinResultSet.next();
			System.out.println(hashPin(saltResultSet.getString(1)+clearPin));
			System.out.println(hashedPinResultSet.getString(1));
			if(hashedPinResultSet.getString(1).equals(hashPin(saltResultSet.getString(1)+clearPin))) return true;
			return false;
		}
		 */
}