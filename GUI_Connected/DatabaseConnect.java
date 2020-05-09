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
				String DBurl 	= "jdbc:mysql://localhost/bank3c";
				String user 	= "";
				String pass 	= "";
				connect = DriverManager.getConnection(DBurl, user, pass);
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		
		// true is when the connection is closed
		public boolean CheckConn() throws SQLException{
		    return connect.isClosed();
		}
		
		// checks in DB if the uid of given card is known
		public boolean checkCuid(String CardUID) throws SQLException{
			PreparedStatement UidStatement = connect.prepareStatement("Select EXISTS(Select * FROM rekening where cardUID = ?)");
			UidStatement.setString(1, CardUID);
			ResultSet UidResultSet = UidStatement.executeQuery();
			UidResultSet.next();
			if(!UidResultSet.getBoolean(1)) System.out.println("UID is not known!");
			return UidResultSet.getBoolean(1);
		}
		
		// checks how many attemps the given card has 
		public int checkAttemps(String CardUID) throws SQLException{
			if(!checkCuid(CardUID)) return -1;
			PreparedStatement attempsStatement = connect.prepareStatement("Select attemps FROM rekening where cardUID = ?");
			attempsStatement.setString(1, CardUID);
			ResultSet attempsResultSet = attempsStatement.executeQuery();
			attempsResultSet.next();
			return attempsResultSet.getInt(1);
		}	
		
		// updates the DB when the pin is not correct
		public void attemptFailed(String CardUID) throws SQLException{	
			System.out.println("Pin is not Correct!");
			PreparedStatement attempsStatement = connect.prepareStatement("UPDATE rekening SET attemps = ? where cardUID = ?");
			attempsStatement.setInt(1, checkAttemps(CardUID)-1);
			attempsStatement.setString(2, CardUID);
			attempsStatement.executeUpdate();
		}
		
		// updates the DB when the pis is correct
		public void attemptCorrect(String CardUID) throws SQLException{	
			PreparedStatement attempsStatement = connect.prepareStatement("UPDATE rekening SET attemps = 3 where cardUID = ?");
			attempsStatement.setString(1, CardUID);
			attempsStatement.executeUpdate();
		}
		
		// returns true when the card is blocked
		public boolean isBlocked(String CardUID) throws SQLException{
			if(!checkCuid(CardUID)) return true;
			PreparedStatement attempsStatement = connect.prepareStatement("Select attemps FROM rekening where cardUID = ?");
			attempsStatement.setString(1, CardUID);
			ResultSet attempsResultSet = attempsStatement.executeQuery();
			attempsResultSet.next();
			if(attempsResultSet.getInt(1) <= 0) return true;
			return false;
		}
		
		// if pin is correct, attemps is set to 3 and return true, or false with attemps - 1
		public boolean checkPin(String CardUID, String clearPin) throws SQLException{
			if(isBlocked(CardUID)) return false;
			PreparedStatement pinStatement = connect.prepareStatement("SELECT PIN FROM rekening WHERE cardUID = ?");
			pinStatement.setString(1, CardUID);
			ResultSet pinResultSet = pinStatement.executeQuery();
			pinResultSet.next();
			if(pinResultSet.getString(1).equals(clearPin)) {
				attemptCorrect(CardUID);
				return true;
			}
			attemptFailed(CardUID);
			return false;
		}
		
		// if the pin is correct give the correct balance
		public float getBalance(String CardUID, boolean pinOK) throws SQLException {
			if(!pinOK) return -1;
			PreparedStatement balanceStatement = connect.prepareStatement("Select saldo FROM rekening where cardUID = ?");
			balanceStatement.setString(1, CardUID);
			ResultSet balanceResultSet = balanceStatement.executeQuery();
			balanceResultSet.next();
			return balanceResultSet.getFloat(1);
		}
		
		// if the pin is correct and there is enough money
		public boolean withdraw(String CardUID, double withdrawAmount, boolean pinOK) throws SQLException{
			if(getBalance(CardUID, pinOK) >= withdrawAmount) {
				PreparedStatement withdrawStatement = connect.prepareStatement("UPDATE rekening SET saldo = (saldo - ?) where cardUID = ?");
				withdrawStatement.setDouble(1, withdrawAmount);
				withdrawStatement.setString(2, CardUID);
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