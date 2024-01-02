package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modeller.Product;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class SaleOperations extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleOperations frame = new SaleOperations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SaleOperations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Geri Dön");
		btnNewButton.setBackground(new Color(153, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel aPanel = new AdminPanel();
				aPanel.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		// Güncel tabloyu Product sınıfından çek ve göster
        TableModel Tablomodel = Product.Initalize();
        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 11, 329, 450);
		contentPane.add(scrollPane);
		
		table = new JTable(Tablomodel);
		table.setEnabled(false);
		scrollPane.setViewportView(table);	
	}
}