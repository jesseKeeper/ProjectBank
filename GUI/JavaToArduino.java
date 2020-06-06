import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.fazecast.jSerialComm.SerialPort;

public class JavaToArduino {
	private static String datum;
	private static String tijd;
	public static String arduinoRekening;
	public static String arduinoBedrag;
	public static String arduinoBon;
	public static String arduinoAutomatisch;
	public static String arduinoBedrag50;
	public static String arduinoBedrag20;
	public static String arduinoBedrag10;
	public static String arduinoBedrag5;
	public static SerialPort sp;

	public static void main(String args[]) throws IOException, InterruptedException {
		System.out.println("mega ready");
		sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
		sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written
		if(portOpen(sp) == false) {
			return;
		}
		getInput();
		sendOutput();
		if(closePort(sp) == false) {
			return;
		}
	}


	public static boolean portOpen(SerialPort sp) {
		if (sp.openPort()) {
			System.out.println("Port is open.");
			return true;
		} 
		else {
			System.out.println("Failed to open port.");
			return false;
		}
	}

	public static void getInput() {
	
			datum = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			datum += "&";
			tijd = new SimpleDateFormat("HH:mm:ss").format(new Date());
			tijd += "&";
			System.out.println("voer rekeningnr in: ");
			System.out.println("rekeningnr: " + arduinoRekening);
			arduinoRekening += "&";
			System.out.println("voer bedrag in: ");
			System.out.println("bedrag: " + arduinoBedrag);
			arduinoBedrag += "&";
			System.out.println("Wel/Geen bon (1/0): "); 
			System.out.println("Bon: " + arduinoBon);
			arduinoBon += "&";
			System.out.println("Wel/Niet automatisch (1/0): ");
			System.out.println("Automatisch: " + arduinoAutomatisch);
			if (arduinoAutomatisch.contains("0")) {	
				manualInput();
			}
			else {
				arduinoBedrag50 = "0&";
				arduinoBedrag20 = "0&";
				arduinoBedrag10 = "0&";
				arduinoBedrag5 = "0&";
			}  
			arduinoAutomatisch += "&";
		}
	

	public static void manualInput() {
			System.out.println("Hoeveelheid 50: ");
			System.out.println(arduinoBedrag50);
			arduinoBedrag50 += "&";
			System.out.println("Hoeveelheid 20: ");
			System.out.println(arduinoBedrag20);
			arduinoBedrag20 += "&";
			System.out.println("Hoeveelheid 10: ");
			System.out.println(arduinoBedrag10);
			arduinoBedrag10 += "&";
			System.out.println("Hoeveelheid 5: ");
			System.out.println(arduinoBedrag5);
			arduinoBedrag5 += "&";
	}

	public static void sendOutput() throws IOException {
		try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
		sp.getOutputStream().write(datum.getBytes());
		sp.getOutputStream().write(tijd.getBytes()); 
		sp.getOutputStream().write(arduinoRekening.getBytes());
		sp.getOutputStream().write(arduinoBon.getBytes());
		sp.getOutputStream().write(arduinoBedrag50.getBytes());
		sp.getOutputStream().write(arduinoBedrag20.getBytes());
		sp.getOutputStream().write(arduinoBedrag10.getBytes());
		sp.getOutputStream().write(arduinoBedrag5.getBytes());
		sp.getOutputStream().write(arduinoAutomatisch.getBytes());
		sp.getOutputStream().write(arduinoBedrag.getBytes());
		sp.getOutputStream().flush();
	}
	
	public static boolean closePort(SerialPort sp) {
		if (sp.closePort()) {
			System.out.println("Port is closed.");
			return true;
		} else {
			System.out.println("Failed to close port.");
			return false;
		}
	}
}