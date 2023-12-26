package modeller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Product {
	public static TableModel Tablomodel = new DefaultTableModel();
	public static ArrayList<Product> listOfProducts = new ArrayList<>();
	private static boolean isFirst = true;
	
	public String id;
	public String name;
	public String count;
	
	static public TableModel Initalize() {
		if (isFirst) {
			
			// ----- Tablo Kodları
			List<String> liste = null; // Declare the list outside the try block
			
			try {
				// Read lines from the file
				liste = Files.readAllLines(Paths.get("C:\\Users\\lupus\\AppData\\Local\\SceneBuilder\\Stok-Otomasyon.git\\src\\proje\\ÜrünListesi.txt"));
			} catch (IOException e) {
				// Handle exceptions, e.g., file not found or unable to read
				e.printStackTrace();
			}
			
			// Check if the list is not null before proceeding
			if (liste != null) {
				Object[] col = {"ID", "Ürün", "Miktar"};
				((DefaultTableModel) Tablomodel).setColumnIdentifiers(col);
				
				for (String product : liste) {
					// Split each line and add the parts to the table model
					String[] p = product.split(",");
					((DefaultTableModel) Tablomodel).addRow(new String[] {p[0],p[1],p[2]});
				}
				
			}
			
			// ----- Tablo Kodu Son
			isFirst = false;
		}
			return Tablomodel;
	}
	
	public Product(String id,String name,String count) {
		
		this.id = id;
		this.name = name;
		this.count = count;
		// Ürün dosyasından ürünleri okuma
		listOfProducts.add(this);

	}
}
