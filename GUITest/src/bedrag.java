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

public class bedrag extends JFrame {

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("C) enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Biljetten kiesbiljetten = new Biljetten();
				kiesbiljetten.setVisible(true);
			}
		});
		btnNewButton.setBounds(176, 147, 103, 32);
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
		btnNewButton_1.setBounds(0, 227, 179, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("B) Afbreken");
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton_2.setBounds(265, 227, 169, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Voer uw gewenste bedrag in");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(96, 11, 264, 70);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setText("\u20AC");
		textField.setBounds(146, 105, 169, 31);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
