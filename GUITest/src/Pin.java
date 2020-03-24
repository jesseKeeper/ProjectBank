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

public class Pin extends JFrame {

	private JPanel contentPane;

	
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voer uw pin in");
		lblNewLabel.setBounds(189, 104, 46, 14);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 33));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("voer uw pin in");
		lblNewLabel_1.setBounds(106, 60, 225, 58);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 33));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("A) enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hoofdmenu mainMenu = new Hoofdmenu();
				mainMenu.setVisible(true);
				
				
				
			}
		});
		btnNewButton.setBounds(172, 170, 89, 23);
		contentPane.add(btnNewButton);
	}

}
