package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modeller.Product;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ProductionPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ProductID;
	private JTextField ProductName;
	private JTextField ProductCount;
	private JTable table;
	private JButton btnGeri;

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
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		// ----- Etiketler
		JLabel Label_UrunEkle_1 = new JLabel("Ürün adı");
		Label_UrunEkle_1.setHorizontalAlignment(SwingConstants.CENTER);
		Label_UrunEkle_1.setBounds(28, 133, 93, 30);
		contentPane.add(Label_UrunEkle_1);
		
		JLabel Label_UrunEkle_1_1 = new JLabel("Adet");
		Label_UrunEkle_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Label_UrunEkle_1_1.setBounds(28, 196, 93, 30);
		contentPane.add(Label_UrunEkle_1_1);
		
		final JLabel lbIDUyarı = new JLabel("");
		lbIDUyarı.setForeground(Color.RED);
		lbIDUyarı.setHorizontalAlignment(SwingConstants.CENTER);
		lbIDUyarı.setBounds(52, 103, 218, 23);
		contentPane.add(lbIDUyarı);
		
		JLabel lblUrunAdı = new JLabel("");
		lblUrunAdı.setForeground(Color.RED);
		lblUrunAdı.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrunAdı.setBounds(52, 162, 218, 23);
		contentPane.add(lblUrunAdı);
		
		
		final JLabel lblAdet = new JLabel("");
		lblAdet.setForeground(Color.RED);
		lblAdet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdet.setBounds(52, 225, 218, 23);
		contentPane.add(lblAdet);
		
		JLabel DurumBildirimi = new JLabel("BİLGİLERİ GİRİN");
		DurumBildirimi.setForeground(new Color(0, 0, 0));
		DurumBildirimi.setBounds(145, 21, 125, 14);
		contentPane.add(DurumBildirimi);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(28, 74, 93, 30);
		contentPane.add(lblId);
		
		// -----


		ProductName = new JTextField();
		ProductName.setColumns(10);
		ProductName.setBounds(145, 133, 125, 30);
		contentPane.add(ProductName);
		
		ProductCount = new JTextField();
		ProductCount.setColumns(10);
		ProductCount.setBounds(145, 196, 125, 30);
		contentPane.add(ProductCount);
		ProductCount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            	try {
					Integer.parseInt(ProductCount.getText());
					lblAdet.setText("");
				} catch (NumberFormatException e2) {
					lblAdet.setText("Geçerli bir sayı girin");
				}
            }

            public void removeUpdate(DocumentEvent e) {
            	try {
					Integer.parseInt(ProductCount.getText());
					lblAdet.setText("");
				} catch (NumberFormatException e2) {
					lblAdet.setText("Geçerli bir sayı girin");
				}
            }

			public void changedUpdate(DocumentEvent e) {
				// Auto-generated method stub
				// No use with text box
			}

        });
		
		// ----- Tablo Kodları		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(345, 11, 329, 450);
		contentPane.add(scrollPane);
		
		table = new JTable(Product.Initalize());
		scrollPane.setViewportView(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				ProductID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				ProductName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				ProductCount.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			}
			
		});
		
		// ----- Tablo Kodu Son
		
		int[] c = {Product.Initalize().getRowCount()};

		ProductID = new JTextField();
		ProductID.setEditable(false);
		ProductID.setColumns(10);
		ProductID.setBounds(145, 74, 125, 30);
		contentPane.add(ProductID);
		ProductID.setText(String.valueOf(c[0]));
		// ----- Butonlar
		
		JButton btnAdd = new JButton("Ekle");
		btnAdd.setBackground(new Color(153, 153, 204));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ürün ismi ve adeti boş ise uyarı veren kod
				if (ProductName.getText().equals("") || ProductCount.getText().equals("")) {
					DurumBildirimi.setText("Boş bırakma");
					return;
				}
				var found = false;
		        // Example: Value to compare against
		        for (int i = 0; i < Product.Initalize().getRowCount(); i++) {
		            // Get the value in the "productname" column for the current row
		            var productNameValue = Product.Initalize().getValueAt(i, 1);

		            // Compare the value with x
		            if (productNameValue != null && productNameValue.equals(ProductName.getText())) {
		                // Do something when the condition is met
		            	var currentValue = Product.Initalize().getValueAt(i, 2);
		            	if (currentValue instanceof Integer) {
		                    int intValue = (Integer) currentValue;
		                    intValue += Integer.parseInt(ProductCount.getText()); // Decrease the value by count
		                    Product.Initalize().setValueAt(intValue, i, 2);
		                }
		            	else {
		            		Product.Initalize().setValueAt(Integer.parseInt((String) currentValue) + Integer.parseInt(ProductCount.getText()), i, 2);
		            		// Perform your action here
						}
		            	found = true;							
		            	break;
		            }
		        }
		        if (!found) {
		        	// Ürünü ismi ve adetini tabloya ekleyen kod
		        	Product product = new Product(ProductID.getText(),ProductName.getText(),ProductCount.getText());
		        	DurumBildirimi.setText("Ürün Eklendi");	
		        	((DefaultTableModel) Product.Initalize()).addRow(new String[] {product.id,product.name,product.count});
		        	table.setModel(Product.Initalize());
		        	c[0]++;
		        	ProductID.setText(String.valueOf(c[0]));
				}
			}
		});
		btnAdd.setBounds(170, 318, 100, 30);
		contentPane.add(btnAdd);
		
		btnGeri = new JButton("Geri Dön");
		btnGeri.setBackground(new Color(153, 153, 204));
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel aPanel = new AdminPanel();
				aPanel.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		
		
//		JButton btnCikar = new JButton("Çıkar");
//		btnCikar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				for (Product i : Product.listOfProducts) {
//					if (ProductName.equals(i.name)) {
//						
//					}
//				}
//			}
//		});
//		btnCikar.setBounds(28, 318, 100, 30);
//		contentPane.add(btnCikar);
		
		JButton btnClear = new JButton("Temizle");
		btnClear.setBackground(new Color(153, 153, 204));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductID.setText(String.valueOf(c[0]));
				ProductName.setText("");
				ProductCount.setText("");
				lbIDUyarı.setText("");
				lblAdet.setText("");
			}
		});
		btnClear.setBounds(28, 318, 100, 30);
		contentPane.add(btnClear);
		

	}
	
}