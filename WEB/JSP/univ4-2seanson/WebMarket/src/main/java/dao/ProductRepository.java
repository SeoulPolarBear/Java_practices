package dao;

import java.util.ArrayList;
import dto.Product;

public class ProductRepository {
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();
	private static ProductRepository instance = new ProductRepository();
	
	
	
	public ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334X 750 Renina HD display,"
				+ "8-megapixel iSight Camera");
		phone.setCategory("Smart Phone");
		phone.setAlcohol("11");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		phone.setFilename("P1234.png");
		
		Product notebook = new Product("P1235", "LG PC �׷�", 1500000);
		notebook.setDescription("13.3-inch, IPS LED display, 5rd Generation Intel"
				+ "Core processors");
		notebook.setCategory("Notebook");
		notebook.setAlcohol("11");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refurbished");
		phone.setFilename("P1235.png");
		
		Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("212.8*6.6mm, Super AMOLED display, Octa-Core processor");
		tablet.setCategory("Tablet");
		tablet.setAlcohol("11");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		phone.setFilename("P1236.png");
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	public ArrayList<Product> getAllProducts(){
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById = null;
		
		for(int i =0; i<listOfProducts.size();i++) {
			Product product = listOfProducts.get(i);
			if(product != null && product.getProductId() != null && 
			product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		
		return productById;

	}
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
 }
