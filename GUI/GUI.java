import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;


public class GUI extends JFrame {
	private JLabel pinLabel;
	private JLabel akkoordPinLabel;
	private JLabel pinMenuLabel;
	private JLabel pinFoutLabel;
	private JLabel saldoCheckLabel;
	private JLabel biljetLabel;
	JPanel body;
	
	// tab gebruikt in GUI
	String kleineTab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	String tab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		getContentPane().setLayout(new CardLayout(0, 0));
		setSize(1920, 1080);
		getContentPane().setBackground(UIManager.getColor("List.selectionBackground"));
		setType(Type.POPUP);
		setType(Type.UTILITY);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // zet fullscreen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		JPanel Begin = new JPanel();
		Begin.setBounds(0, 0, 1920, 190);
		getContentPane().add(Begin);
		Begin.setBackground(UIManager.getColor("List.selectionBackground"));
		Begin.setLayout(null);
		
		JLabel StonksBenc = new JLabel("STONKS BENC");
		StonksBenc.setBounds(getWidth()/2 - 390/2, 35, 390, 90);
		StonksBenc.setFont(new Font("Tahoma", Font.PLAIN, 60));
		Begin.add(StonksBenc);
		
//		--------------------------------------------- Bovenste strook van GUI
		body = new JPanel();
		body.setBounds(10, 200, 1894, 840);
		body.setBackground(UIManager.getColor("List.selectionBackground"));
		Begin.add(body);
		body.setLayout(new CardLayout(0, 0));
		
		JPanel welkomScherm = new JPanel();
		JLabel welkomLabel = new JLabel("<html>Welkom bij STONKS BENC<br>&nbsp;Houd uw pas bij de lezer</html>");
		welkomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welkomLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		body.add(welkomScherm, "welkomScherm");
		welkomScherm.setBackground(UIManager.getColor("List.selectionBackground"));
		welkomScherm.setLayout(new CardLayout(0, 0));
		welkomScherm.add(welkomLabel, "WelkomLabel");
		
		// ------------------------
		JPanel pinScherm = new JPanel();
		pinLabel = new JLabel("");
		pinLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pinScherm.setBackground(UIManager.getColor("List.selectionBackground"));
		body.add(pinScherm, "pinScherm");
		pinScherm.setLayout(new CardLayout(0, 0));
		pinScherm.add(pinLabel, "pinLabel");
			
		// ------------------------
		JPanel hoofdMenuScherm = new JPanel();
		JLabel hoofdMenuLabel = new JLabel("<html><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "A) $70,- " + tab + "C) Check saldo<br><br><br><br><br><br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "B) Kies uw bedrag " + kleineTab + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#) Afbreken");
		hoofdMenuLabel.setVerticalAlignment(SwingConstants.TOP);
		hoofdMenuLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		hoofdMenuScherm.setBackground(UIManager.getColor("List.selectionBackground"));
		body.add(hoofdMenuScherm, "hoofdMenuScherm");
		hoofdMenuScherm.setLayout(new CardLayout(0, 0));
		hoofdMenuScherm.add(hoofdMenuLabel, "Menu A, B, C, #");
	
		// ------------------------
		JPanel akkoordPinScherm = new JPanel();
		akkoordPinLabel = new JLabel("");
		akkoordPinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		akkoordPinLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		akkoordPinScherm.setBackground(UIManager.getColor("List.selectionBackground"));
		body.add(akkoordPinScherm, "akkoordPinScherm");
		akkoordPinScherm.setLayout(new CardLayout(0, 0));
		akkoordPinScherm.add(akkoordPinLabel, "akkoordPinScherm");
		
		// ------------------------
		JPanel saldoCheckScherm = new JPanel();
		saldoCheckLabel = new JLabel("");
        saldoCheckLabel.setHorizontalAlignment(SwingConstants.CENTER);
        saldoCheckLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		saldoCheckScherm.setBackground(UIManager.getColor("List.selectionBackground"));
		body.add(saldoCheckScherm, "saldoCheckScherm");
		saldoCheckScherm.setLayout(new CardLayout(0, 0));
        saldoCheckScherm.add(saldoCheckLabel, "saldoCheckLabel");
		
	    // ------------------------
		JPanel pinFoutScherm = new JPanel();
		pinFoutLabel = new JLabel("");
        pinFoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pinFoutLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        pinFoutScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(pinFoutScherm, "pinFoutScherm");
        pinFoutScherm.setLayout(new CardLayout(0, 0));
        pinFoutScherm.add(pinFoutLabel, "pinFoutLabel");

        // ------------------------
        JPanel geblokkeerdScherm = new JPanel();
        JLabel geblokkeerdLabel = new JLabel("<html><br><br>Uw pas is geblokkeerd</html>");
        geblokkeerdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        geblokkeerdLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        geblokkeerdScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(geblokkeerdScherm, "geblokkeerdScherm");
        geblokkeerdScherm.setLayout(new CardLayout(0, 0));
        geblokkeerdScherm.add(geblokkeerdLabel, "geblokkeerdLabel");

        // ------------------------
        JPanel onvoldoendeSaldoScherm = new JPanel();
        JLabel onvoldoendeSaldoLabel = new JLabel("<html><br><br>Uw heeft niet genoeg saldo.</html>");
        onvoldoendeSaldoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        onvoldoendeSaldoLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        onvoldoendeSaldoScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(onvoldoendeSaldoScherm, "onvoldoendeSaldoScherm");
        onvoldoendeSaldoScherm.setLayout(new CardLayout(0, 0));
        onvoldoendeSaldoScherm.add(onvoldoendeSaldoLabel, "onvoldoendeSaldoLabel");
        
        // ------------------------
        JPanel bonScherm = new JPanel();
        JLabel bonLabel = new JLabel("<html>Wilt u een bon printen?<br><br><br><br><br>A) Ja  " + kleineTab + "B) Nee</html>");
        bonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bonLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        bonScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(bonScherm, "bonScherm");
        bonScherm.setLayout(new CardLayout(0, 0));
        bonScherm.add(bonLabel, "bonLabel");

        // ------------------------
        JPanel biljetScherm = new JPanel();
        biljetLabel = new JLabel("");
        biljetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        biljetLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        biljetScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(biljetScherm, "biljetScherm");
        biljetScherm.setLayout(new CardLayout(0, 0));
        biljetScherm.add(biljetLabel, "biljetLabel");
        
        // ------------------------
        JPanel bedanktScherm = new JPanel();
        JLabel bedankLabel = new JLabel("<html>Bedankt voor het pinnen bij Stonks Benc</html>");
        bedankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bedankLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        bedanktScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(bedanktScherm, "bedanktScherm");
        bedanktScherm.setLayout(new CardLayout(0, 0));
        bedanktScherm.add(bedankLabel, "bedankLabel");
        
        // ------------------------
        JPanel ongeldigScherm = new JPanel();
        JLabel ongeldigBedragLabel = new JLabel("<html>Het bedrag dat u heeft ingetoetst is niet correct <br><br><br> Voer een bedrag in wat gepint kan worden");
        ongeldigBedragLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ongeldigBedragLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        ongeldigScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(ongeldigScherm, "ongeldigScherm");
        ongeldigScherm.setLayout(new CardLayout(0, 0));
        ongeldigScherm.add(ongeldigBedragLabel, "ongeldigBedragLabel");
        
        // ------------------------
        JPanel pinMenuScherm = new JPanel();
        pinMenuScherm.setBackground(UIManager.getColor("List.selectionBackground"));
        body.add(pinMenuScherm, "pinMenuScherm");
        pinMenuScherm.setLayout(new CardLayout(0, 0));
        
        pinMenuLabel = new JLabel("");
        pinMenuLabel.setVerticalAlignment(SwingConstants.TOP);
        pinMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pinMenuLabel.setBounds(getWidth()/2, getHeight()/2, 200, 50);
        pinMenuLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        pinMenuScherm.add(pinMenuLabel, "pinMenuLabel");
	}
	
	public void pinInvoerScherm(int pin_) {
		String pinCode;
		String checkPin = " ";
		if(pin_ == 0) {
			pinCode = " <br><br><br>";
		} else if(pin_ == 1) {
			pinCode = "* <br><br><br>";
		} else if(pin_ == 2) {
			pinCode = "** <br><br><br>";
		} else if(pin_ == 3) {
			pinCode = "*** <br><br><br>";
		} else if(pin_ == 4) {
			pinCode = "**** <br><br><br>";
			checkPin = "*) Check pin";
		} else {
			pinCode = " ";
		}
		pinLabel.setText("<html>Voer uw pincode in: &nbsp;&nbsp;&nbsp;&nbsp;" + pinCode + "D) Reset pin" + kleineTab + "#) Afbreken <br><br><br>" + checkPin);
		showPanel("pinScherm");
	}
	
	public void pinMenu(int bedrag_) {
		String pinMenuTekst = "<html><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        		+ "A) $30,-" + kleineTab + kleineTab 
        		+ "C) $90,-<br><br><br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "B) $50,- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "Hoeveel wilt u pinnen? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "D) Biljetten kiezen"
				+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + kleineTab 
				+ "$" + bedrag_ + ",-"
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "*) Doorgaan" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + kleineTab 
				+ "#) Reset / afbreken</html>";
		pinMenuLabel.setText(pinMenuTekst);
		showPanel("pinMenuScherm");
	}
	
	public void pinZelfkiesMenu(int bedrag_) {
		String biljetTekst = "<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        		+ "A) +$5,-" + kleineTab + kleineTab 
        		+ "C) +$20,-<br><br><br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "B) +$10,- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "Hoeveel wilt u pinnen? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "D) +$50,-"
				+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + kleineTab 
				+ "$" + bedrag_ + ",-"
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "*) Doorgaan" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + kleineTab 
				+ "#) Reset / afbreken</html>";
		biljetLabel.setText(biljetTekst);
		showPanel("biljetScherm");
	}
	
	public void foutPinScherm(int pogingen) {
		pinFoutLabel.setText("<html><br><br> Uw pincode is onjuist, probeer opnieuw. <br><br><br> U heeft " + pogingen + " pogingen over</html>");
		showPanel("pinFoutScherm");
	}
	
	public void akkoordPinScherm(int bedrag_) {
		akkoordPinLabel.setText("<html>Weet u zeker dat u $" + bedrag_ + ",- wilt pinnen?<br><br><br><br><br>A) Ja " + kleineTab + "B) Nee</html>");
		showPanel("akkoordPinScherm");
	}
	
	public void saldoCheckScherm(float saldo) {
		saldoCheckLabel.setText("<html><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Uw saldo is " + saldo + "0<br><br><br><br><br>A) Terug naar Hoofdmenu </html>");
		showPanel("saldoCheckScherm");
	}
	
	public void kiesMenuScherm(int bedrag) {
		showPanel("biljetScherm");
	}
	
	public void showPanel(String scherm){
		CardLayout c = (CardLayout)(body.getLayout());
		c.show(body, scherm);
	}
}
