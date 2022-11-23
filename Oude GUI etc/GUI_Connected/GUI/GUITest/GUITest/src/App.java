import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.sql.*;  

public class App implements gegevens {

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
		
		global myglobal = new global();
		myglobal.Hrekening = rekening; 
		myglobal.hPogingen = pogingen;
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
		btnNewButton.setBounds(170, 204, 190, 56);
		frmGui.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A) taal kiezen");
		btnNewButton_1.setBounds(387, 327, 125, 23);
		frmGui.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Welkom bij Stons benc");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(105, 86, 339, 86);
		frmGui.getContentPane().add(lblNewLabel);

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

