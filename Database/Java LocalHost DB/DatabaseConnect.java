import java.sql.*;

public class DatabaseConnect {
		public static String isClosed;
		private Connection connect;


		public void ConnectToDB() {
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
				String DBurl 	= "jdbc:mysql://localhost/bank3c"; // use your localhost with the desired database
				String user 	= ""; // use your own limited user 
				String pass 	= ""; // with its own password
				connect = DriverManager.getConnection(DBurl, user, pass);
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
		
		public boolean CheckConn() throws SQLException{
		    return connect.isClosed();
		}
		
		public boolean checkCuid(String CardUID) throws SQLException{
			PreparedStatement UidStatement = connect.prepareStatement("Select EXISTS(Select * FROM rekening where cardUID = ?)");
			UidStatement.setString(1, CardUID);
			ResultSet UidResultSet = UidStatement.executeQuery();
			UidResultSet.next();
			return UidResultSet.getBoolean(1);
		}
		
		public int checkAttemps(String CardUID) throws SQLException{
			PreparedStatement attempsStatement = connect.prepareStatement("Select attemps FROM rekening where cardUID = ?");
			attempsStatement.setString(1, CardUID);
			ResultSet attempsResultSet = attempsStatement.executeQuery();
			attempsResultSet.next();
			return attempsResultSet.getInt(1);
		}	
		
		public void updateAttemps(String CardUID, int updateAttemps) throws SQLException{
			PreparedStatement attempsStatement = connect.prepareStatement("UPDATE rekening SET attemps = ? where cardUID = ?");
			attempsStatement.setInt(1, updateAttemps);
			attempsStatement.setString(2, CardUID);
			attempsStatement.executeUpdate();
		}
		
		public boolean isBlocked(String CardUID) throws SQLException{
			PreparedStatement attempsStatement = connect.prepareStatement("Select attemps FROM rekening where cardUID = ?");
			attempsStatement.setString(1, CardUID);
			ResultSet attempsResultSet = attempsStatement.executeQuery();
			attempsResultSet.next();
			if(attempsResultSet.getInt(1) == 0) {
				return true;
			}
			return false;
		}
		
		/* Belangrijk dat eerst de CardUID gecheckt is of die bestaat*/
		public boolean checkPin(String CardUID, String clearPin) throws SQLException{
			PreparedStatement pinStatement = connect.prepareStatement("SELECT PIN FROM rekening WHERE cardUID = ?");
			pinStatement.setString(1, CardUID);
			ResultSet pinResultSet = pinStatement.executeQuery();
			pinResultSet.next();
			return pinResultSet.getString(1).equals(clearPin);
		}
		
		private static Object hashPin(Object x) {
			return x.hashCode();
		}		
		
		public boolean checkHashedPin(String CardUID, String clearPin) throws SQLException{
			PreparedStatement saltStatement = connect.prepareStatement("SELECT Salt FROM rekening WHERE cardUID = ?");
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
		
		public float getBalance(String CardUID, boolean pinOK) throws SQLException {
			if(!pinOK) return -1;
			PreparedStatement balanceStatement = connect.prepareStatement("Select saldo FROM rekening where cardUID = ?");
			balanceStatement.setString(1, CardUID);
			ResultSet balanceResultSet = balanceStatement.executeQuery();
			balanceResultSet.next();
			return balanceResultSet.getFloat(1);
		}
		
		public boolean withdraw(String CardUID, double withdrawAmount, boolean pinOK) throws SQLException{
			if(!pinOK) return false;
			if(getBalance(CardUID, pinOK) > withdrawAmount) {
				PreparedStatement withdrawStatement = connect.prepareStatement("UPDATE rekening SET saldo = (saldo - ?) where cardUID = ?");
				withdrawStatement.setDouble(1, withdrawAmount);
				withdrawStatement.setString(2, CardUID);
				withdrawStatement.executeUpdate();
				return true;
			}
			return false;
		}
		
}