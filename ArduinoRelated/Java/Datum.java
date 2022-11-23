import java.text.SimpleDateFormat;
import java.util.Date;

public class Datum {

	public String datum() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date currentDate = new Date();
		return formatter.format(currentDate);
	}
	
	/*
	 Dit is een string met een datum erin. 
	 */
}
