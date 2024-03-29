import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTextPane;  
public class bedrag extends JFrame implements gegevens{

	private JPanel contentPane;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bedrag frame = new bedrag();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public bedrag() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Afbreken(*");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Integer.parseInt(textField.getText());
				global myglobal = new global();
			
				if(a < myglobal.Hrekening) {
				snelGeld();
					dispose();
				Biljetten kiesbiljetten = new Biljetten();
				kiesbiljetten.setVisible(true);
				} else {
					dispose();
					wSaldo saldo = new wSaldo();
					saldo.setVisible(true);
				}
				}
				
				}
				
		
	);
		btnNewButton.setBounds(1500, 940, 424, 81);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A) terug naar hoofdscherm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hoofdmenu menu = new Hoofdmenu();
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setBounds(0, 0, 424, 81);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("B) ENTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pin npin = new Pin();
				npin.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_2.setBounds(0, 470, 424, 81);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Voer uw gewenste bedrag in");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(880, 470, 89, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField(); 
	
		JLabel lblNewLabel_1 = new JLabel("\u20AC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(880, 470, 89, 20);
		contentPane.add(lblNewLabel_1);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(830, 400, 225, 58);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("C)");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(0, 940, 424, 81);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("(D");
		btnNewButton_4.setBounds(1500, 0, 424, 81);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("(#");
		btnNewButton_5.setBounds(1500, 470, 424, 81);
		contentPane.add(btnNewButton_5);
	}


	@Override
	public double snelGeld() {
		double a = Integer.parseInt(textField.getText());
		global myglobal = new global();
        myglobal.Hrekening  = myglobal.Hrekening - a;
		
		return myglobal.Hrekening;
	}


	@Override
	public int pin() {
		// TODO Auto-generated method stub
		return 0;
	}
}
