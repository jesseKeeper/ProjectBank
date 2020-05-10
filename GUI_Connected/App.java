import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class App implements gegevens {

	JFrame frmGui;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public App() {
		initialize();
		
	}
	
	private void initialize() {
		global myglobal = new global();
		myglobal.Hrekening = rekening; 
		myglobal.hPogingen = pogingen;
		frmGui = new JFrame();
		frmGui.setTitle("GUI");
		//frmGui.setBounds(100, 100, 528, 389);
		frmGui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmGui.setUndecorated(true);
		frmGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGui.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("bied uw pas aan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGui.dispose();
			Pin inlog = new Pin();
			inlog.setVisible(true);
		
		
			
			}
		});
		btnNewButton.setBounds(880, 470, 190, 56);
		frmGui.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afbreken (*");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(1500, 940, 424, 81);
		frmGui.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welkom bij Stons benc");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(830, 400, 405, 86);
		frmGui.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("A)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(0, 0, 424, 81);
		frmGui.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("B)");
		btnNewButton_3.setBounds(0, 470, 424, 81);
		frmGui.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("C)");
		btnNewButton_4.setBounds(0, 940, 424, 81);
		frmGui.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("(D");
		btnNewButton_5.setBounds(1500, 0, 424, 81);
		frmGui.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("(#");
		btnNewButton_6.setBounds(1500, 470, 424, 81);
		frmGui.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("../images/stonks.png"));
		lblNewLabel_1.setBounds(820, 0, 847, 271);
		frmGui.getContentPane().add(lblNewLabel_1);
		
		

}


	@Override
	public double snelGeld() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int pin() {
		// TODO Auto-generated method stub
		return 0;
	}

}

