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

//BMI(ü��������) : ������ / (Ű * Ű) -> Ű : m ���� ------------------------2
	public void BMI(double height, double weight) {
		this.BMI = weight / Math.pow((height / 100), 2);
	}
	
	public double getBMI() {
		return BMI;
	}

	public String Result(double BMI) {
		String result = "";
		// 18.5�̸��̸� ��ü��----------------------------3
		if (BMI < 18.5)
			result = "��ü��";

		else {
			// 18.5�̻��̸� ����
			if (18.5 <= BMI && BMI < 25)
				result = "��ü��";
			// 25�̻��̸� ��ü��
			else if (25 <= BMI && BMI < 30)
				result = "��ü��";
			// 30�̻��̸� �浵��
			else if (30 <= BMI && BMI < 35)
				result = "�浵��";
			// 35�̻��̸� ������ ��
			else if (35 <= BMI && BMI < 40)
				result = "������ ��";
			// 40�̻��̸� ����
			else if (40 <= BMI)
				result = "����";
		}
		return result;
	}


}
