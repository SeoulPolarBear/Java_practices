package ShoppingMall;

public class ShoppingMall {
private Shoes shoes;
private Computer computer;
private NoteBook notebook;

public ShoppingMall(Shoes shoes, Computer computer, NoteBook notebook) {
	super();
	this.shoes = shoes;
	this.computer = computer;
	this.notebook = notebook;
}

public Shoes getShoes() {
	return shoes;
}

public void setShoes(Shoes shoes) {
	this.shoes = shoes;
}

public Computer getComputer() {
	return computer;
}

public void setComputer(Computer computer) {
	this.computer = computer;
}

public NoteBook getNotebook() {
	return notebook;
}

public void setNotebook(NoteBook notebook) {
	this.notebook = notebook;
}

public void printInfo() {
	System.out.println("==========================");
	shoes.printInfo();
	System.out.println("==========================");
	computer.printInfo();
	System.out.println("==========================");
	notebook.printInfo();
	System.out.println("==========================");
}
}
