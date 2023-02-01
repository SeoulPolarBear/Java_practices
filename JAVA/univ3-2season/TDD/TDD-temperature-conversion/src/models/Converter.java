package models;

public class Converter {
	public double ftoc(double d) throws Exception
	 {
	if (d < -459.67) throw new Exception("Illegal temperature value");
	 return (d - 32) * 5 / 9;
	 }

	public double ctof(double d) throws Exception
	{
	 if (d < -273.15) throw new Exception("Illegal temperature value");
	 return d * 9 / 5 + 32;
	 }
	
	 public double ktoc(double d) throws Exception
	{
	 if (d < 0) throw new Exception("Illegal value for temperature");
	return d - 273.15;
	}
	
	public double ctok(double d) throws Exception
	 {
	if (d < -273.15) throw new Exception("Illegal value for temperature");
	return d + 273.15;
	}
	
	public double ktof(double d) throws Exception
	 {
	if (d < 0) throw new Exception("Illegal value for temperature");
	return d * 9 / 5 - 459.67;
	 }
	
	 public double ftok(double d) throws Exception
	 {
	if (d < -459.67) throw new Exception("Illegal value for temperature");
	 return (d + 459.67) * 5 / 9;
	}

}
