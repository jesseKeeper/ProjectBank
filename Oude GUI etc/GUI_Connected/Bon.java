import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
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
		//setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
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
		btnNewButton.setBounds(0, 0, 424, 81);
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
		btnNewButton_1.setBounds(0, 470, 424, 81);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Wilt u een bon?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 27));
		lblNewLabel.setBounds(830, 400, 225, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("C)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			Hoofdmenu nHoofdmenu = new Hoofdmenu();
			nHoofdmenu.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(0, 940, 424, 81);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("(D");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Pin nPin = new Pin();
				nPin.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(1500, 0, 424, 81);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("(#");
		btnNewButton_4.setBounds(1500, 470, 424, 81);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Afbreken(*");
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				App window = new App();
				window.frmGui.setVisible(true);;	
			}
		});
		btnNewButton_5.setBounds(1500, 940, 424, 81);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Tim Karadeniz\\Pictures\\stonks.png"));
		lblNewLabel_2.setBounds(820, 0, 847, 271);
		contentPane.add(lblNewLabel_2);
	}

}
