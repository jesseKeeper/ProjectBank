import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.sql.*;  
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
		//setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("#) Terug naar hoofdscherm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hoofdmenu terugGaan= new Hoofdmenu();
				terugGaan.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBounds(1500, 470, 424, 81);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afbreken(*");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				App window = new App();
				window.frmGui.setVisible(true);
					}
				});
			
		
		btnNewButton_1.setBounds(1500, 940, 424, 81);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("A) \u20AC5,00");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon1= new Bon();
				bon1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(0, 0, 424, 81);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("B) \u20AC10,00");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon2= new Bon();
				bon2.setVisible(true);
			}
			
		});
		btnNewButton_3.setBounds(0, 470, 424, 81);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("C) \u20AC20,00");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon3= new Bon();
				bon3.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(0, 940, 424, 81);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("D) \u20AC50,00");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bon bon4= new Bon();
				bon4.setVisible(true);
			
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Tim Karadeniz\\Pictures\\stonks.png"));
				lblNewLabel_2.setBounds(820, 0, 847, 271);
				contentPane.add(lblNewLabel_2);
			}
		});
		btnNewButton_5.setBounds(1500, 0, 424, 81);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Welke biljetten wilt u?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel.setBounds(830, 400, 225, 58);
		contentPane.add(lblNewLabel);
	}

}
