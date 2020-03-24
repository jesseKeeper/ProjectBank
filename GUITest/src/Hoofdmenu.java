import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hoofdmenu extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hoofdmenu frame = new Hoofdmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Hoofdmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("A) \u20AC70 pinnen");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Afsluiting snelPinnen = new Afsluiting();
				snelPinnen.setVisible(true);
			}
		});
		btnNewButton.setBounds(29, 54, 152, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("B) Saldo checken");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setBounds(29, 126, 152, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C)Zelf bedrag pinnen");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				bedrag bedraginvoeren = new bedrag();
				bedraginvoeren.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_2.setBounds(29, 191, 152, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("#)Afbreken");
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_3.setBounds(252, 55, 152, 26);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("*) taal veranderen");
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_4.setBounds(252, 129, 152, 26);
		contentPane.add(btnNewButton_4);
	}

}
