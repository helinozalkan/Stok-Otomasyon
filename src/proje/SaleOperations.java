package proje;

import java.awt.EventQueue;

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
import java.awt.Color;
public class SaleOperations extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTable table;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public SaleOperations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Geri Dön");
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel aPanel = new AdminPanel();
				aPanel.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		
		var Tablomodel = new DefaultTableModel();
		Object[] col = {"ID","Ürün","Miktar"};
		Tablomodel.setColumnIdentifiers(col);
		for (Product product : Product.listOfProducts) {
			Tablomodel.addRow(new String[] {product.id,product.name,product.count});
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 0, 326, 478);
		contentPane.add(scrollPane);
		
		table = new JTable(Tablomodel);
		scrollPane.setViewportView(table);
		
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO Auto-generated method stub
//				ProductID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
//				ProductName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
//				ProductCount.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
//			}
//			
//		});
		
		
		
	}
	

}