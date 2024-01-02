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
			List<String> liste = null;
			
			try {
				// Ürün listesinden satırları okuma
				liste = Files.readAllLines(Paths.get("C:\\Users\\lupus\\AppData\\Local\\SceneBuilder\\Stok-Otomasyon.git\\src\\proje\\ÜrünListesi.txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (liste != null) {
				// Sütün adlarını ayarlama
				Object[] col = {"ID", "Ürün", "Miktar"};
				((DefaultTableModel) Tablomodel).setColumnIdentifiers(col);
				
				for (String product : liste) {
					// Ürün Listesindeki ürünleri "," işareti göre ayırıp tabloya atama
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
