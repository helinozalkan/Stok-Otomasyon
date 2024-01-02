package proje;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modeller.Product;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;


public class SatisIslemleri extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTextField ProductName;
    private JTextField ProductCount;
    private JLabel DurumBildirimi;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SatisIslemleri frame = new SatisIslemleri();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SatisIslemleri() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
        TableModel Tablomodel = new DefaultTableModel();
		// ----- Tablo Kodları
		List<String> liste = null; // Declare the list outside the try block
		
		try {
			// Ürün listesinden satırları okuma
			liste = Files.readAllLines(Paths.get("C:\\Users\\lupus\\AppData\\Local\\SceneBuilder\\Stok-Otomasyon.git\\src\\proje\\SatilikUrunListesi.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Sütün adlarını ayarlama
		if (liste != null) {
			Object[] col = {"ID", "Ürün", "Miktar"};
			((DefaultTableModel) Tablomodel).setColumnIdentifiers(col);
			
			for (String product : liste) {
				// Ürün Listesindeki ürünleri "," işareti göre ayırıp tabloya atama
				String[] p = product.split(",");
				((DefaultTableModel) Tablomodel).addRow(new String[] {p[0],p[1],p[2]});
			}
			
		}
		
		// ----- Tablo Kodu Son
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(345, 11, 329, 450);
		contentPane.add(scrollPane);
		
		table = new JTable(Tablomodel);
		scrollPane.setViewportView(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				ProductName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				ProductCount.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			}
			
		});

        ProductName = new JTextField();
        ProductName.setBounds(140, 145, 150, 30);
        contentPane.add(ProductName);

        ProductCount = new JTextField();
        ProductCount.setBounds(140, 205, 150, 30);
        contentPane.add(ProductCount);
		ProductCount.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            	try {
					Integer.parseInt(ProductCount.getText());
					DurumBildirimi.setText("");
				} catch (NumberFormatException e2) {
					DurumBildirimi.setText("Geçerli bir sayı girin");
				}
            }

            public void removeUpdate(DocumentEvent e) {
            	try {
					Integer.parseInt(ProductCount.getText());
					DurumBildirimi.setText("");
				} catch (NumberFormatException e2) {
					DurumBildirimi.setText("Geçerli bir sayı girin");
				}
            }

			public void changedUpdate(DocumentEvent e) {
				// Auto-generated method stub
				// No use with text box
			}
        });


        DurumBildirimi = new JLabel("");
        DurumBildirimi.setForeground(new Color(255, 0, 0));
        DurumBildirimi.setHorizontalAlignment(SwingConstants.CENTER);
        DurumBildirimi.setBounds(53, 106, 200, 20);
        contentPane.add(DurumBildirimi);
        
        JLabel lblNewLabel = new JLabel("Ürün İsmi");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 145, 100, 22);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Miktar");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 213, 89, 14);
        contentPane.add(lblNewLabel_1);
        
        JButton btnAdd = new JButton("Satışı Ekle");
        btnAdd.setBackground(new Color(153, 153, 204));
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				// Ürün ismi ve adeti boş ise uyarı veren kod
				if (ProductName.getText().equals("") || ProductCount.getText().equals("")) {
					DurumBildirimi.setText("Boş bırakma");
					return;
				}
				// Ürünün bulunup bulunmadığına dair bir değer
				var found = false;
				// Listedeki bütün ürünleri karşılaştırmak için for döngüsü
		        for (int i = 0; i < Product.Initalize().getRowCount(); i++) {
		        	// Bu satırdaki ürün adını bir değere atama
		            var productNameValue = Product.Initalize().getValueAt(i, 1);

		            // Ürün adının bizim istediğimiz ürün ile aynı olup olmadığını kontrol etme
		            if (productNameValue != null && productNameValue.equals(ProductName.getText())) {
		                // Eğer doğru ise ürün miktarını girilen miktar kadar arttırma
		            	var currentValue = Product.Initalize().getValueAt(i, 2);
		            	if (currentValue instanceof Integer) {
		                    int intValue = (Integer) currentValue;
		                    intValue -= Integer.parseInt(ProductCount.getText()); // Ürünün miktarını düşür
		                    Product.Initalize().setValueAt(intValue, i, 2);
		                }
		            	else {
		            		Product.Initalize().setValueAt(Integer.parseInt((String) currentValue) - Integer.parseInt(ProductCount.getText()), i, 2);
						}
		            	
		            	currentValue = Tablomodel.getValueAt(i, 2);
		            	if (currentValue instanceof Integer) {
		                    int intValue = (Integer) currentValue;
		                    intValue += Integer.parseInt(ProductCount.getText()); // Decrease the value by count
		                    Tablomodel.setValueAt(intValue, i, 2);
		                }
		            	else {
		            		Tablomodel.setValueAt(Integer.parseInt((String) currentValue) + Integer.parseInt(ProductCount.getText()), i, 2);
						}
		            	
		            	found = true;							
		            	break;
		            }
		        }
		        if (!found) {
		        	DurumBildirimi.setText("Yanlış ürün ismi");
				}
			}
        });
        btnAdd.setBounds(170, 318, 100, 30);
        contentPane.add(btnAdd);

        JButton btnGeriDön = new JButton("Geri Dön");
        btnGeriDön.addActionListener(e -> {
            dispose();
        });
        btnGeriDön.setBounds(10, 11, 89, 23);
        contentPane.add(btnGeriDön);

        JButton btnClear = new JButton("Temizle");
        btnClear.setBackground(new Color(153, 153, 204));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductName.setText("");
				ProductCount.setText("");
				
			}
        });
        btnClear.setBounds(28, 318, 100, 30);
        contentPane.add(btnClear);
    }
}
