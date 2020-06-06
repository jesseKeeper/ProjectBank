import java.sql.SQLException;

public class Program {
	static DatabaseConnect db;
	/*
	 * In Program.java wordt de communicatie geopend en stopt het programma als er een verbinding verbroken is.
	 * Com tussen java-geldautomaat
	 * Com tussen java-pinapparaat
	 * Com tussen java-database / API
	 * 
	 * 
	 * Checkpin, maak een string methode aan die aangeroepen wordt en die de scanner of arduino gebruikt om de string te returnen.
	 */
	
	public static void main(String[] args) throws SQLException {
		db = new DatabaseConnect();
		getConnections(db);
	}
	
	private static void getConnections(DatabaseConnect db) throws SQLException {
		
		try {
			db.ConnectToDB();
			String status = db.CheckConn() ? "Closed" : "Open";
			System.out.println("Connection to DB: " + status);			
		} catch (NullPointerException e) {
			System.err.println("Server not online!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		while(!db.CheckConn()) {
			// roep GUI functie aan om die te blijven draaien.
		}
	}
}
