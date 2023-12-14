package proje;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modeller.Product;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ProductList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
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
	public ProductList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 218, 251);
		contentPane.add(scrollPane);
		
		var model = new DefaultTableModel();
		Object[] col = {"Ürün"};
		model.setColumnIdentifiers(col);

		for (String i : Product.arr) {
			model.addRow(new String[] {i});
		}

		
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Geri Dön");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel aPanel = new AdminPanel();
				aPanel.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(324, 21, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}

}
