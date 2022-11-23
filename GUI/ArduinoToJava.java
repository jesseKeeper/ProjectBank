import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class ArduinoToJava {
	public static int inputLength;
	public static String data = "";
	SerialPort activePort;
	int COM;
	public ArduinoToJava(int COM){
		this.COM = COM;
	}

	public void getArduinoData() {
		activePort = SerialPort.getCommPort("COM"+COM);
		System.out.println("Uno ready");
		if (activePort.openPort()) {
			System.out.println(activePort.getPortDescription() + " port opened.");
		}

		activePort.addDataListener(new SerialPortDataListener() {

			@Override
			public void serialEvent(SerialPortEvent event) {	
				for(int i = 0; i < 3; i++) {
					byte[] newData = new byte[activePort.bytesAvailable()]; //receive incoming bytes
					activePort.readBytes(newData, newData.length); //read incoming bytes
					data += new String(newData); //convert bytes to string
					try
					{
						Thread.sleep(20);
					}
					catch(InterruptedException ex)
					{
						Thread.currentThread().interrupt();
					}
				}				
				if (data != null) {	
					guiOutput(inputLength);	
					data = "";
				}
			}

			@Override
			public int getListeningEvents() { 
				return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;  
			}
		});
	}

	public String guiOutput(int charLength) {
//		System.out.println(charLength);
//		System.out.println(data.length());

		if(data != null) {
			if(charLength == 1 && data.length() == 1) {
				return data;
			}

			else if(charLength == 11 && data.length() == 11) {
				//activePort.closePort();
				return data;
			}

			else if(charLength == 16 && data.length() == 16) {
				//activePort.closePort();
				return data;
			}

			else {
				//System.out.println("else");
				//System.out.println(data);
			}
		}
		return "-1";
	}

	public void guiInput(int length) {
		inputLength = length;
		return;
	}

	public void close() {
		activePort.closePort();
	}
}