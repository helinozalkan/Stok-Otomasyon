package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		// --- Pencere ayarları
		setBackground(SystemColor.infoText);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lupus\\AppData\\Local\\SceneBuilder\\Stok-Otomasyon.git\\src\\proje\\packages.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 103, 497, 205);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);
		tabbedPane.addTab("Admin", null, panel, null);

		// --- Kullanıcı adı ve şifre
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(170, 57, 112, 20);
		panel.add(textName);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(170, 89, 112, 20);
		panel.add(passwordField);
		
		// --- Etiketler
		
		JLabel lblNewLabel = new JLabel("Giriş yapın");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 11, 112, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/proje/supermarket (3).png")));
		lblNewLabel_1.setBounds(334, -93, 575, 376);
		panel.add(lblNewLabel_1);
		
		JLabel lblAlert = new JLabel("");
		
		lblAlert.setForeground(new Color(255, 0, 0));
		lblAlert.setBounds(129, 68, 187, 26);
		contentPane.add(lblAlert);
		
		JLabel Label_Isim = new JLabel("İsim");
		Label_Isim.setIcon(new ImageIcon(Login.class.getResource("/proje/profile.png")));
		Label_Isim.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Isim.setBounds(23, 57, 103, 23);
		panel.add(Label_Isim);
		
		JLabel lblNewLabel_2 = new JLabel(" Şifre");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/proje/key.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(23, 91, 97, 17);
		panel.add(lblNewLabel_2);
		
		// --- Buton
		
		
		JButton btnNewButton = new JButton("Giriş");
		btnNewButton.setBackground(new Color(153, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// İsim ve şifre doğru mu kontrolu
				if (textName.getText().equals("Admin") && passwordField.getText().equals("123")) {
					AdminPanel adminPanel = new AdminPanel();
					adminPanel.setVisible(true);
					dispose();
				}
				// Yanlış ise uyarı göster
				else {
					lblAlert.setText("Yanlış kullanıcı adı veye şifre");
				}

			}
		});
		btnNewButton.setBounds(170, 131, 112, 35);
		panel.add(btnNewButton);

		
	}
}