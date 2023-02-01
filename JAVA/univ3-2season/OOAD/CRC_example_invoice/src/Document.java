
public abstract class Document {
	
	Product aProduct;
	int quantity;
	
	public abstract void add(Product aProduct, int quantity);
	public abstract String format();

}
