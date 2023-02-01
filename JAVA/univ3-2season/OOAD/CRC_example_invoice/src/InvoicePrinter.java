
public class InvoicePrinter {

	public static void main(String[] args) {
		
		Address samsAddress
		 = new Address("Sam's Small Appliances",
		 "100 Main Street", "Anytown", "CA", "98765");
		
		Address tomsAddress
		 = new Address("Tom's Small Appliances",
		 "120 Main Street", "Sometown", "CA", "94321");
		
		Address kimsAddress
		 = new Address("Kim's Small Appliances",
		 "120 Main Street", "µø¿€±∏", "KR", "30");
		
		
		
		
		Invoice samsInvoice = new Invoice(samsAddress);
		samsInvoice.add(new Product("Toaster", 29.95), 3);
		samsInvoice.add(new Product("Hair dryer", 24.95), 1);
		samsInvoice.add(new Product("Car vacuum", 19.99), 2);
		
		Receipt KimsReceipt = new Receipt(kimsAddress);
		KimsReceipt.add(new Product("Toaster", 29.95), 3);
		KimsReceipt.add(new Product("Hair dryer", 24.95), 1);
		KimsReceipt.add(new Product("Car vacuum", 19.99), 2);
		
		Invoice TomsInvoice = new Invoice(tomsAddress);
		TomsInvoice.add(new Product("Mini Oven", 29.00), 1);
		TomsInvoice.add(new Product("air Frier", 33.05), 1);
		 TomsInvoice.add(new Product("Car Light", 9.50), 2);
		
		Receipt SamsReceipt = new Receipt(samsAddress);
		SamsReceipt.add(new Product("Mini Oven", 29.00), 1);
		SamsReceipt.add(new Product("air Frier", 33.05), 1);
		SamsReceipt.add(new Product("Car Light", 9.50), 2);
		
		Invoice KimsInvoice = new Invoice(kimsAddress);
		KimsInvoice.add(new Product("Chicken", 9.00), 1);
		KimsInvoice.add(new Product("Hamburger", 3.05), 1);
		KimsInvoice.add(new Product("Pizza", 9.50), 1);
		
		
		System.out.println(samsInvoice.format());
		System.out.println(KimsReceipt.format());
		System.out.println(TomsInvoice.format());
		System.out.println(SamsReceipt.format());
		System.out.println(KimsInvoice.format());
	}
}
