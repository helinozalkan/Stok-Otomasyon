package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 154, 497, 205);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Admin", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Personel", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Müşteri", null, panel_2, null);
		
		
		JLabel lblNewLabel = new JLabel("Giriş yapın");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 11, 112, 35);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(170, 57, 112, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(170, 89, 112, 20);
		panel.add(textField_1);
		
		JLabel Label_Isim = new JLabel("İsim");
		Label_Isim.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Isim.setBounds(34, 60, 86, 14);
		panel.add(Label_Isim);
		
		JLabel lblNewLabel_2 = new JLabel("Şifre");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(34, 92, 86, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Giriş");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel adminPanel = new AdminPanel();
				adminPanel.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(170, 131, 112, 35);
		panel.add(btnNewButton);
		

		
	}
}
