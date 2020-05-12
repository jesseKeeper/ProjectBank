import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import com.fazecast.jSerialComm.SerialPort;
/**
 * Simple application that is part of an tutorial. 
 * The tutorial shows how to establish a serial connection between a Java and Arduino program.
 * @author Michael Schoeffler (www.mschoeffler.de)
 *
 */ 
public class MainClass {
  public static void main(String[] args) throws IOException, InterruptedException {
    SerialPort sp = SerialPort.getCommPort("COM8"); // device name TODO: must be changed
    sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
    sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written
    
    if (sp.openPort()) {
      System.out.println("Port is open");     
    } else {
      System.out.println("Failed to open port :(");
      return;
    }  
      
    try (Scanner scanner = new Scanner(System.in)) {
  //  Integer bedrag = scanner.nextInt();
  //  sp.getOutputStream().write(bedrag.byteValue());
    
    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    date += "&";
    String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
    time += "&";
   
    System.out.println("voer rekeningnr in: ");
    String rekening = scanner.next();
    System.out.println("rekeningnr: " + rekening);
    System.out.println("voer bedrag in: ");
    String bedrag = scanner.next();
    System.out.println("bedrag:" + bedrag);
    rekening += "&";
    bedrag += "&";
    
    sp.getOutputStream().write(date.getBytes());
    sp.getOutputStream().write(time.getBytes()); 
    sp.getOutputStream().write(rekening.getBytes());
    sp.getOutputStream().write(bedrag.getBytes());
    sp.getOutputStream().flush();
    }
    
    if (sp.closePort()) {
      System.out.println("Port is closed :)");
    } else {
      System.out.println("Failed to close port :(");
      return;
    }
    
  }
}
