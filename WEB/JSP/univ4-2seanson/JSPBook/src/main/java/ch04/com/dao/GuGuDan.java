package ch04.com.dao;
import java.io.Serializable;
public class GuGuDan {
	
	public GuGuDan() {
		
	}
	public int[] process(int n) {
		int arr[] = new int[9];
		for(int i = 1; i<10; i++) {
			arr[i-1] = n*i;
		}
		return arr;
	}
}
