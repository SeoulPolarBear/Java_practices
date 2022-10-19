package BMIproj;

public class Myprofile {
private String name;
private double height;
private double weight;
private double BMI;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}

//BMI(체질량지수) : 몸무게 / (키 * 키) -> 키 : m 단위 ------------------------2
	public void BMI(double height, double weight) {
		this.BMI = weight / Math.pow((height / 100), 2);
	}
	
	public double getBMI() {
		return BMI;
	}

	public String Result(double BMI) {
		String result = "";
		// 18.5미만이면 저체중----------------------------3
		if (BMI < 18.5)
			result = "저체중";

		else {
			// 18.5이상이면 정상
			if (18.5 <= BMI && BMI < 25)
				result = "저체중";
			// 25이상이면 과체중
			else if (25 <= BMI && BMI < 30)
				result = "과체중";
			// 30이상이면 경도비만
			else if (30 <= BMI && BMI < 35)
				result = "경도비만";
			// 35이상이면 중증도 비만
			else if (35 <= BMI && BMI < 40)
				result = "중증도 비만";
			// 40이상이면 고도비만
			else if (40 <= BMI)
				result = "고도비만";
		}
		return result;
	}


}
