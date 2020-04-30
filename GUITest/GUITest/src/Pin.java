import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;  
public class Pin extends JFrame implements gegevens {

	private JPanel contentPane;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pin frame = new Pin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Pin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voer uw pin in");
		lblNewLabel.setBounds(189, 104, 46, 14);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 33));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("voer uw pin in");
		lblNewLabel_1.setBounds(830, 400, 225, 58);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 33));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("A) enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				global myglobal = new global();
				String psd=passwordField.getText();
				
				if(psd.equals("1111")) {
				
					dispose();
				Hoofdmenu mainMenu = new Hoofdmenu();
				mainMenu.setVisible(true);
				}
				else
				{
					pin();
					if(myglobal.hPogingen > 0) {
					dispose();
					pogingen nPogingen = new pogingen();
					nPogingen.setVisible(true);
					}else {
						dispose();
						Block nBlock = new Block();
						nBlock.setVisible(true);
					}
				} 
					
				
				
			}
		});
		btnNewButton.setBounds(0, 0, 424, 81);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(880, 470, 89, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("B)");
		btnNewButton_1.setBounds(0, 470, 424, 81);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C)");
		btnNewButton_2.setBounds(0, 940, 424, 81);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("(D");
		btnNewButton_3.setBounds(1500, 0, 424, 81);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("(#");
		btnNewButton_4.setBounds(1500, 470, 424, 81);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("(*Afbreken");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(1500, 940, 424, 81);
		contentPane.add(btnNewButton_5);
	}


	@Override
	public double snelGeld() {
		
		return 0;
	}


	@Override
	public int pin() {
		global myglobal = new global();
		myglobal.hPogingen = myglobal.hPogingen - pogingMinder;
		return myglobal.hPogingen;
	}
}
