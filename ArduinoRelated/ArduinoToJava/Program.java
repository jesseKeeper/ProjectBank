import java.io.IOException;

import com.fazecast.jSerialComm.SerialPort;

public class Program {
	public static int gui = 1;
	public static void main(String[] args) {

		System.out.println("hoi");
		
		//MEGA
		JavaToArduino.sp = SerialPort.getCommPort("COM8");

			JavaToArduino.arduinoRekening = "2069";
			JavaToArduino.arduinoBedrag = "85";
			JavaToArduino.arduinoBon = "1";
			JavaToArduino.arduinoAutomatisch = "1";
			JavaToArduino.arduinoBedrag50 = "0";
			JavaToArduino.arduinoBedrag20 = "0";
			JavaToArduino.arduinoBedrag10 = "0";
			JavaToArduino.arduinoBedrag5 = "0";
			try {
			JavaToArduino.main(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//UNO
//		ArduinoToJava arduinotojava = new ArduinoToJava(6);
//		arduinotojava.getArduinoData();
//		while(gui != 0) {
//			if(arduinotojava.guiOutput(gui) != "-1"){ 
//				System.out.println(arduinotojava.guiOutput(gui));
//				gui = 0;
//			}
//			arduinotojava.guiInput(gui);
//			try
//			{
//				Thread.sleep(10);
//			}
//			catch(InterruptedException ex)
//			{
//				Thread.currentThread().interrupt();
//			}
//		}

	}
}
