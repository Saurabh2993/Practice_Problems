package leetcode_medium;

public class Complex_Number_Multiplication {
	
	public static void main(String args[]) {
		
		String x1 = "1+1i";
		String x2 = "1+1i";
		
		String result = complexNumberMultiply(x1, x2);
		System.out.println(result);
		
	}
	
	public static String complexNumberMultiply(String a, String b) {
		
		String result = "";
		
		String x1_variables[] = a.split("\\+");
		String x2_variables[] = b.split("\\+");
		
		int c = Integer.parseInt(x1_variables[0]);
		int d = Integer.parseInt(x1_variables[1].split("i")[0]);
		int e = Integer.parseInt(x2_variables[0]);
		int f = Integer.parseInt(x2_variables[1].split("i")[0]);
		
		int p = (c * e) - (d * f);
		int q = (c * f) + (d * e);
		
		result = p + "+" + q + "i";
		
//		System.out.println(result);
		
		return result;
		
	}

}
