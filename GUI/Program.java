import java.io.IOException;
import java.sql.SQLException;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.EventQueue;

public class Program {
	static GUI gui;
	static DatabaseConnect db = new DatabaseConnect();
	private static String data = null;
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui = new GUI();
					gui.showPanel("menuScherm");
					gui.setVisible(true);
					db.ConnectToDB();
					String status = db.CheckConn() ? "Closed" : "Open";
					System.out.println("Connection to DB: " + status);    
				} catch (NullPointerException e) {
					System.err.println("Server not online!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			delay(500);
			start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// functie om te pinnen en om te zorgen dat dit niet vaker voorkomt.
	private static boolean pinnen(String iBan, int withdrawAmount, boolean pin) throws SQLException{
		return db.withdraw(iBan, withdrawAmount, pin);
	}

	// delay functie voor java gemaakt 	
	private static void delay(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	// begin van de GUI, hier wordt gevraagd om een iBan van de Arduino
	public static void start() throws SQLException{
		gui.showPanel("welkomScherm");
		uno(16);
		String iBan = data;
		pinInvoer(iBan);
	}

	// als de gegeven iBan bij ons bekend is en niet geblokkeerd is mag de pincode ingevoerd worden
	private static void pinInvoer(String iBan) throws SQLException{
		String pin = "";
		if(!db.isBlocked(iBan)){ // checkt of iBan bestaat of geblokkeerd is.
			gui.showPanel("pinScherm");
			int b = 0;
			while(b == 0) { // while loop zodat je op * moet drukken of op # als je de pin wilt resetten anders doet ie niks en wordt er op een * of # gewacht
				while(pin.length() <= 3) { // zorgt ervoor dat er 4 cijfers komen in de pin string komen
					gui.pinInvoerScherm(pin.length());
					uno(1);
					if(data.equals("A") || data.equals("B") || data.equals("C") || data.equals("N") || data.equals("*")){ // zorgt ervoor dat er geen letters in de pin kunnen komen
					} else if(data.equals("D")){ // de pin wordt geleegd
						pin = ""; 
						System.out.println("Pin is geleegd");
					} else if(data.equals("#")) {
						start();
					} else {
						pin += data;
						System.out.println(pin);
					}
				}
				gui.pinInvoerScherm(pin.length());
				uno(1);
				if(data.equals("*")) {
					b = 1; // gaat uit de loop
				} else if (data.equals("D")) {
					pinInvoer(iBan);
				} else if (data.equals("#")) {
					start();
				}
			}
			// zorgt ervoor dat de pin niet opgeslagen blijft en dat we wel de kunnen checken of de pin goed is.
			boolean pinBool = db.checkPin(iBan, pin);
			pin = "";
			if(pinBool){
				hoofdMenu(iBan, pinBool);
			} else {
				pinFout(iBan, db.checkAttemps(iBan));
			}
		} else {
			gui.showPanel("geblokkeerdScherm");
			delay(3000);
			start();
		}
	}

	// roept een foute pin scherm aan met het aantal pogingen over
	private static void pinFout(String iBan, int attempts) throws SQLException{
		gui.foutPinScherm(attempts);
		delay(2500);
		pinInvoer(iBan);
	}

	// het hoofdmenu van de GUI
	private static void hoofdMenu(String iBan, Boolean pin) throws SQLException {
		gui.showPanel("hoofdMenuScherm");
		int b = 0;
		while(b == 0) {
			uno(1);
			if(data.equals("A")) {
				snelpinMenu(iBan, pin);
				b = 1;
			} else if(data.equals("B")) {
				pinMenu(iBan, pin);
				b = 1;
			} else if(data.equals("C")) {
				checkSaldoMenu(iBan, pin);
				b = 1;
			} else if(data.equals("#")) {
				start();
				b = 1;
			}
		}
	}

	private static void snelpinMenu(String iBan, boolean pin) throws SQLException {
		int bedrag = 70;
		gui.akkoordPinScherm(bedrag);
		int b = 0;
		while(b == 0) {
			uno(1);
			if(data.equals("A")) {				
				if(pinnen(iBan, bedrag, pin)){
					bon(iBan, String.valueOf(bedrag), "0", "1","1","0","0");
				} else {
					weinigSaldo(iBan, pin);
				}
				b = 1;
			} else if(data.equals("B")) {
				hoofdMenu(iBan, pin);
				b = 1;
			}
		} 
	}

	private static String bedragSt;
	private static void pinMenu(String iBan, boolean pin) throws SQLException {
		bedragSt = "";
		gui.pinMenu(0);
		int b = 0;
		while(b == 0) {
			uno(1);
			if(data.equals("A")) {
				bedragSt = "30";
				b = 1;
			} else if(data.equals("B")) {
				bedragSt = "50";
				b = 1;
			} else if(data.equals("C")) {
				bedragSt = "90";
				b = 1;
			} else if(data.equals("D")) {
				bedragSt = "kiesMenu";
				b = 1;
			} else if(data.equals("*")){
				b = 1;
			} else if(data.equals("#")){
				if(bedragSt == "") {
					start();
				}
				pinMenu(iBan, pin);
			} else {
				bedragSt += data;
				gui.pinMenu(Integer.parseInt(bedragSt));
			}
		}
		int bedrag = 0;
		if(bedragSt == "kiesMenu") {
			kiesMenu(iBan, pin);
		} else {
			bedrag = Integer.parseInt(bedragSt);
			if(bedrag % 5 == 0) {
				normaalpinMenu(iBan, bedrag, pin);		
			} else {
				gui.showPanel("ongeldigScherm");
				delay(3000);
				pinMenu(iBan, pin);
			}
		}
	}

	private static void normaalpinMenu(String iBan, int bedrag, boolean pin) throws SQLException {
		gui.akkoordPinScherm(bedrag);
		int b = 0;
		while(b == 0) {
			uno(1);
			if(data.equals("A")) {				
				if(pinnen(iBan, bedrag, pin)){
					bon(iBan, String.valueOf(bedrag), "1", "0","0","0","0");
				} else {
					weinigSaldo(iBan, pin);
				}
				b = 1;
			} else if(data.equals("B")) {
				hoofdMenu(iBan, pin);
				b = 1;
			}
		} 
	}
	
	private static void geavanceerdpinMenu(String iBan, int bedrag, boolean pin, String bedrag50, String bedrag20, String bedrag10, String bedrag5) throws SQLException {
		gui.akkoordPinScherm(bedrag);
		int b = 0;
		while(b == 0) {
			uno(1);
			if(data.equals("A")) {				
				if(pinnen(iBan, bedrag, pin)){
					bon(iBan, String.valueOf(bedrag), "0", bedrag50, bedrag20, bedrag10, bedrag5);
				} else {
					weinigSaldo(iBan, pin);
				}
				b = 1;
			} else if(data.equals("B")) {
				hoofdMenu(iBan, pin);
				b = 1;
			}
		} 
	}

	private static void kiesMenu(String iBan, boolean pin) throws SQLException {
		int bedrag = 0;
		gui.pinZelfkiesMenu(0);
		int bedrag50 = 0;
		int bedrag20 = 0;
		int bedrag10 = 0;
		int bedrag5 = 0;
		int b = 0;
		while(b == 0) {
			uno(1);
			if(data.equals("A")) {
				bedrag += 5;
				bedrag5++;
			} else if(data.equals("B")) {
				bedrag += 10;
				bedrag10++;
			} else if(data.equals("C")) {
				bedrag += 20;
				bedrag20++;
			} else if(data.equals("D")) {
				bedrag += 50;
				bedrag50++;
			} else if(data.equals("*")){
				b = 1;
			} else if(data.equals("#")){
				if(bedrag == 0) {
					start();
				}
				kiesMenu(iBan, pin);
			}
			gui.pinZelfkiesMenu(bedrag);
		}
		if(bedrag % 5 == 0) {
			geavanceerdpinMenu(iBan, bedrag, pin, String.valueOf(bedrag50), String.valueOf(bedrag20), String.valueOf(bedrag10), String.valueOf(bedrag5));	
		} else {
			gui.showPanel("ongeldigScherm");
			delay(5000);
			pinMenu(iBan, pin);
		}
	}

	private static void checkSaldoMenu(String iBan, boolean pin) throws SQLException {
		float saldo = db.getBalance(iBan, pin);
		if(saldo != -1) {
			gui.saldoCheckScherm(saldo);
			while(data != null) {
				uno(1);
				if(data.equals("A")) {
					hoofdMenu(iBan, pin);
				}
			}
		}
		start();
	}

	private static void bon(String iBan, String bedrag, String automatisch, String bedrag50, String bedrag20, String bedrag10, String bedrag5) throws SQLException {
		gui.showPanel("bonScherm");
		int b = 0;
		while(b == 0) {
			uno(1);
			if(data.equals("A")) {
				mega(iBan, bedrag, "1", automatisch, bedrag50, bedrag20, bedrag10, bedrag5);
				bedankt();
				b = 1;
			} else if(data.equals("B")) {
				mega(iBan, bedrag, "0", automatisch, bedrag50, bedrag20, bedrag10, bedrag5);
				bedankt();
				b = 1;
			}
		}
	}

	private static void bedankt() throws SQLException {
		gui.showPanel("bedanktScherm");
		delay(5000);
		start();
	}

	private static void weinigSaldo(String iBan, boolean pin) throws SQLException{
		gui.showPanel("onvoldoendeSaldoScherm");
		delay(3000);
		hoofdMenu(iBan, pin);
	}

	public static String uno(int gui) {
		//UNO
		ArduinoToJava arduinotojava = new ArduinoToJava(6);
		arduinotojava.getArduinoData();
		while(gui != 0) {
			if(arduinotojava.guiOutput(gui) != "-1"){ 
				System.out.println(arduinotojava.guiOutput(gui));
				data = arduinotojava.guiOutput(gui);
				gui = 0;
			}
			arduinotojava.guiInput(gui);
			delay(10);
		}
		arduinotojava.close();
		return data;
	}

	// dispenser code 
	public static void mega(String rekening, String bedrag, String bon, String automatisch, String bedrag50, String bedrag20, String bedrag10, String bedrag5) {
		JavaToArduino.sp = SerialPort.getCommPort("COM8");
		JavaToArduino.arduinoRekening = rekening;
		JavaToArduino.arduinoBedrag = bedrag;
		JavaToArduino.arduinoBon = bon;
		JavaToArduino.arduinoAutomatisch = automatisch;
		JavaToArduino.arduinoBedrag50 = bedrag50;
		JavaToArduino.arduinoBedrag20 = bedrag20;
		JavaToArduino.arduinoBedrag10 = bedrag10;
		JavaToArduino.arduinoBedrag5 = bedrag5;
		try {
			JavaToArduino.main(null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}