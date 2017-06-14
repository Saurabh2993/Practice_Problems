package test_Package;

public class Digit_One_Occurences {
	
	public static void main(String args[]) {
		
		int x = 1410065408;
		int y = 1;
		
		getOccurences(x, y);
	}
	
	public static int getOccurences(int x, int y) {
		
		if(x < 10) {
			return x + 1 > y ? 1 : 0;
		}
		
		long temp = 1;
		long count = 0;
		
		while(x >= temp * 10) {
			count = count * 10 + temp;
			temp = temp * 10;
		}
		System.out.println(count);
		count = count * (x / temp);
		if(x >= (y + 1) * temp) {
			count = count + temp;
		} else {
			count = count + (x - temp) + 1;
		}
		System.out.println(count);
		count = count + getOccurences((int) (x % temp), y);
		System.out.println(count);
		
		return (int) count;
	}

}
