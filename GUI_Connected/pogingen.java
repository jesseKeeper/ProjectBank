import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pogingen extends JFrame implements gegevens {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pogingen frame = new pogingen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		
			
	}

	/**
	 * Create the frame.
	 */
	public pogingen() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		global myglobal = new global();
		JLabel lblNewLabel = new JLabel("U heeft nog " + myglobal.hPogingen  + " pogingen over");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(790, 400, 355, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("terug naar pin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pin nPin = new Pin();
				nPin.setVisible(true);
			}
		});
		btnNewButton.setBounds(880, 470, 134, 23);
		contentPane.add(btnNewButton);
		
	
		
		 
			 
		
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
