package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("ÜRÜN EKLE");
		btnNewButton_1.setBackground(new Color(153, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductionPanel productionPanel = new ProductionPanel();
				productionPanel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(20, 160, 194, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("SATIŞ İŞLEMLERİ");
		btnNewButton_1_1.setBackground(new Color(153, 153, 204));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SatisIslemleri ui = new SatisIslemleri();
				ui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(20, 233, 194, 48);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("STOK DURUMU");
		btnNewButton_1_2.setBackground(new Color(153, 153, 204));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleOperations panel = new SaleOperations();
				panel.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_2.setBounds(250, 160, 194, 48);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("ÇIKIŞ YAP");
		btnNewButton_1_3.setBackground(new Color(153, 153, 204));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3.setBounds(250, 233, 194, 48);
		contentPane.add(btnNewButton_1_3);
	}

}