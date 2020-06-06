import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frmGui;

	
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
		frmGui = new JFrame();
		frmGui.setTitle("GUI");
		frmGui.setBounds(100, 100, 528, 389);
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
		btnNewButton.setBounds(178, 204, 183, 56);
		frmGui.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A) taal kiezen");
		btnNewButton_1.setBounds(387, 327, 125, 23);
		frmGui.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welkom bij stonks benc");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 33));
		lblNewLabel.setBounds(96, 59, 341, 98);
		frmGui.getContentPane().add(lblNewLabel);
	}
}
