import java.util.ArrayList;

public class RuleBook {
	private String name;
	private ArrayList<String> ruleBook = new ArrayList<>();
	
	
	
	public RuleBook(String name, String ...rule) {
		this.name = name;
		for (String i : rule) {
			this.ruleBook.add(i);
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getRuleBook() {
		return ruleBook;
	}

	public void setRuleBook(ArrayList<String> ruleBook) {
		this.ruleBook = ruleBook;
	}

	
	
	
	
	
}
