import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;  


public class Hoofdmenu extends JFrame implements gegevens {

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
		//setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("A) \u20AC70 pinnen");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				global myglobal = new global();
				if( myglobal.Hrekening > snelPinnen) {
					snelGeld();
				dispose();
				Afsluiting snelPinnen = new Afsluiting();
				snelPinnen.setVisible(true);
				
			
				}
				else {
					dispose();
					wSaldo mGeld = new wSaldo();
					mGeld.setVisible(true);
				}
				}
		});
		btnNewButton.setBounds(0, 0, 424, 81);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("B) Saldo checken");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Saldo saldoMove = new Saldo();
				saldoMove.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.setBounds(0, 470, 424, 81);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C) Zelf bedrag pinnen");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				bedrag bedraginvoeren = new bedrag();
				bedraginvoeren.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_2.setBounds(0, 940, 424, 81);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("(D");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_3.setBounds(1500, 0, 424, 81);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton(" taal veranderen(#");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_4.setBounds(1500, 470, 424, 81);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Afbreken(*");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pin nPin = new Pin();
				nPin.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(1500, 940, 424, 81);
		contentPane.add(btnNewButton_5);
	}



	@Override
	public double snelGeld() {
		global myglobal = new global();
        myglobal.Hrekening  = myglobal.Hrekening - snelPinnen;
		
		return myglobal.Hrekening;
	}



	@Override
	public int pin() {
		// TODO Auto-generated method stub
		return 0;
	}
			
	}



