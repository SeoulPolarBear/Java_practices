
import java.util.ArrayList;

public class Receipt {

	private Address billingAddress;
	private ArrayList<LineItem> items;
	
	public Receipt(Address anAddress)
	{
		items = new ArrayList<LineItem>();
		billingAddress = anAddress;
	}
	
	public void add(Product aProduct, int quantity)
	{
		LineItem anItem = new LineItem(aProduct, quantity);
		items.add(anItem);
	}
	
	public String format()
	{
		String R = "                       R E C E I P T\n\n"
				+ billingAddress.format()
				+ String.format("\n\n%-30s%8s&%5s%8s\n",
				"Description", "Price", "Qty", "Total");
		
		for (LineItem item : items)
		{
			R = R + item.format() + "\n";
		}
	
	     R = R + String.format("\nAmount Received: $%8.2f", getAmountReceived());
	     
	     return R;
	}

	private double getAmountReceived()
	{
		double amountReceived = 0;
		for(LineItem item : items)
		{
			amountReceived = amountReceived + item.getTotalPrice();
		}
		amountReceived = amountReceived*1.1;
		
		return amountReceived;
	}
}
