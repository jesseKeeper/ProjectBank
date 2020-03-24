import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bon extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bon frame = new Bon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Bon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("A) Ja");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Afsluiting vaarwel = new Afsluiting();
				vaarwel.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 22));
		btnNewButton.setBounds(65, 124, 117, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("B) Nee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Afsluiting vaarwel2 = new Afsluiting();
				vaarwel2.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 22));
		btnNewButton_1.setBounds(258, 124, 104, 50);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Wilt u een bon?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 27));
		lblNewLabel.setBounds(118, 38, 205, 50);
		contentPane.add(lblNewLabel);
	}

}
