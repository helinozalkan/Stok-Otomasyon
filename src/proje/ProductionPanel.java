package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modeller.Product;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ProductionPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ProductName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductionPanel frame = new ProductionPanel();
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
	public ProductionPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ProductName = new JTextField();
		ProductName.setBounds(127, 11, 125, 30);
		contentPane.add(ProductName);
		ProductName.setColumns(10);
		
		JLabel Label_UrunEkle = new JLabel("Ürün adı");
		Label_UrunEkle.setHorizontalAlignment(SwingConstants.CENTER);
		Label_UrunEkle.setBounds(10, 11, 93, 30);
		contentPane.add(Label_UrunEkle);
		
		JLabel DurumBildirimi = new JLabel("");
		DurumBildirimi.setForeground(new Color(128, 255, 0));
		DurumBildirimi.setBounds(127, 60, 125, 14);
		contentPane.add(DurumBildirimi);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product.arr.add(ProductName.getText());
				ProductName.setText("");
				DurumBildirimi.setText("Ürün Eklendi");
				
			}
		});
		btnNewButton.setBounds(305, 11, 101, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Geri Dön");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel aPanel = new AdminPanel();
				aPanel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(566, 15, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}

}
