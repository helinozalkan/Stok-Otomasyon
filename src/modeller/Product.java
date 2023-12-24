package modeller;


import java.util.ArrayList;

public class Product {
	
	public static ArrayList<Product> listOfProducts = new ArrayList<>();
	
	public String id;
	public String name;
	public String count;
	
	public Product(String id,String name,String count) {
		this.id = id;
		this.name = name;
		this.count = count;
		
		listOfProducts.add(this);	
	}
}
