import java.sql.SQLException;

public class Program {

	public static void main(String[] args) {
		ServerDBConnect db = new ServerDBConnect();
		
		try {
			db.connectToServer();		
			String status = null;
			status = db.CheckConn() ? "Failed" : "Open";
			System.out.println("DB connection status: " + status);
		} catch (SQLException e) {
			System.err.println("Connection failed!");
			e.printStackTrace();
		}
		String UID = "21 9C 87 6A";
		

		try {
			
			System.out.println(db.checkHashedPin(UID, "1111"));
			
			/*
			float saldo;
			System.out.println(db.isBlocked(UID));
			db.withdraw(UID, 0.21, db.isBlocked(UID));
			saldo = db.getBalance(UID, false);
			System.out.println(saldo);
			
			String uid;
			uid = db.checkCUID(UID) ? "Yes" : "Nope";
			System.out.println("Uid correct: " + uid);

			int attemps;
			attemps = db.checkAttemps(UID);
			System.out.println("Attemps: " + attemps);
		 
			boolean blocked;
			blocked = db.isBlocked(UID);
			System.out.println("blocked: " + blocked);*/
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
