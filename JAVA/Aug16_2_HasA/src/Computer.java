
public class Computer {
	private String cpu;
	private int ram;
	private int HDD;
	private Company company;

	public Computer(String cpu, int ram, int hDD, Company company) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.HDD = hDD;
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHDD() {
		return HDD;
	}

	public void setHDD(int hDD) {
		HDD = hDD;
	}

	public void printInfo() {
		System.out.printf("CPU : %s RAM : %dGB HDD : %dGB \n", cpu, ram, HDD);
		company.CompanyInfo();
	}

}
