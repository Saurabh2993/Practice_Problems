package leetcode_easy;

public class Number_Complement {
	
	public static void main(String args[]) {
		
		int x = 13;
		
		int ans = findComplement(x);
		System.out.println(ans);
		
	}
	
	public static int findComplement(int num) {
		
		int result = 0;
		int power_counter = 0;
		
		String binaryIntNum = Integer.toBinaryString(num);
		
		for (int i = binaryIntNum.length() - 1; i >= 0; i--) {
			
			String currentChar = binaryIntNum.substring(i, i + 1);
			
			if(currentChar.equals("0")) {
				result = (int) (result + Math.pow(2, power_counter));
				power_counter++;
			}
			else {
				power_counter++;
			}
			
		}
//		System.out.println(result);
		
		return result;
		
	}

}
