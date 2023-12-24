package proje;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Product {
    String id;
    String name;
    String count;

    public Product(String id, String name, String count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}

public class UserInformation extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTextField ProductID;
    private JTextField ProductName;
    private JTextField ProductCount;
    private JLabel DurumBildirimi;

    private DefaultTableModel tableModel;
    private List<Product> listOfProducts;
    private int idCounter;

    private static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserInformation frame = new UserInformation();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UserInformation() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        listOfProducts = new ArrayList<>();
        idCounter = 1;

        JButton btnGeri = new JButton("Geri git");
        btnGeri.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		AdminPanel adminPanel = new AdminPanel();
        		adminPanel.setVisible(true);
        		dispose();
        	}
            // Geri git işlemleri buraya eklenmeli
            
        });
        btnGeri.setBounds(10, 11, 89, 23);
        contentPane.add(btnGeri);

        tableModel = new DefaultTableModel();
        Object[] col = {"ID", "Ürün", "Miktar"};
        tableModel.setColumnIdentifiers(col);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(345, 45, 429, 400);
        contentPane.add(scrollPane);

        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        table.getSelectionModel().addListSelectionListener(e -> {
            ProductID.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            ProductName.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            ProductCount.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        });

        ProductName = new JTextField();
        ProductName.setBounds(140, 145, 150, 30);
        contentPane.add(ProductName);

        ProductCount = new JTextField();
        ProductCount.setBounds(140, 205, 150, 30);
        contentPane.add(ProductCount);

        DurumBildirimi = new JLabel("");
        DurumBildirimi.setBounds(28, 138, 200, 20);
        contentPane.add(DurumBildirimi);

        JButton btnAdd = new JButton("Satışı Ekle");
        btnAdd.addActionListener(e -> {
            addProduct();
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
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ProductID.setText(String.valueOf(c[0]));
				ProductName.setText("");
				ProductCount.setText("");
				
			}
        });
        btnClear.setBounds(28, 318, 100, 30);
        contentPane.add(btnClear);
    }

    private void addProduct() {
        if (ProductName.getText().equals("") || ProductCount.getText().equals("")) {
            DurumBildirimi.setText("Boş bırakma");
            return;
        }

        Product product = new Product(String.valueOf(idCounter), ProductName.getText(), ProductCount.getText());
        listOfProducts.add(product);
        tableModel.addRow(new String[]{product.id, product.name, product.count});
        idCounter++;
        clearFields();
        DurumBildirimi.setText("Ürün Eklendi");
    }

    private void clearFields() {
        ProductID.setText("");
        ProductName.setText("");
        ProductCount.setText("");
        DurumBildirimi.setText("");
    }}