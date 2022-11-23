public class HashPassword {

	private static Object hashPass(Object x) {
		return x.hashCode();
	}
	
	private static Object geefHashedPin(String account) {
		if (account == "Jesse") return 1693385226;
		return " ";
	}
	
	private static boolean pinCorrect(Object pin, String salt){
//		String salt = "Jesse"; //geefVoornaam(account);
		return (hashPass(salt+pin).equals(geefHashedPin("Jesse")));
	}
	
	
	public static void main(String[] args) {
		String y = "1111";
		String salt = "Jesse";
			System.out.println("Hash " + y + " to "+ hashPass(salt+y) + "\n" + pinCorrect(1111, "Jesse"));		
	} 
}