import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Biljetten extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biljetten frame = new Biljetten();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Biljetten() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("#)Terug naar hoofdscherm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hoofdmenu terugGaan= new Hoofdmenu();
				terugGaan.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(0, 227, 163, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("*)Afbreken");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(271, 227, 163, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("A)\u20AC5,00");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon1= new Bon();
				bon1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(74, 66, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("B)\u20AC10,00");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon2= new Bon();
				bon2.setVisible(true);
			}
			
		});
		btnNewButton_3.setBounds(271, 66, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("C)\u20AC20,00");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon3= new Bon();
				bon3.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(74, 171, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("D)\u20AC50,00");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon4= new Bon();
				bon4.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(271, 171, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Welke biljetten wilt u?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel.setBounds(112, 11, 227, 34);
		contentPane.add(lblNewLabel);
	}

}
