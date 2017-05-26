package leetcode_medium;

public class Counting_Bits {
	
	public static void main (String args[]) {
		
		int num = 31;
		
		int ans[] = countBits(num);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i] + " ");
		}
		
	}
	
	public static int[] countBits(int num) {
		
		int[] result = new int[num + 1];
		
/*		for (int i = 0; i <= num; i++) {

			O(n * length of binary number) solution
			
			System.out.println(i);
			
			String binaryNum = Integer.toBinaryString(i);
			
			for (int j = 0; j < binaryNum.length(); j++) {
				
				if(binaryNum.charAt(j) == '1') {
					one_count ++;
				} else {
					continue;
				}
			} */
			
/* 			O(n * log(i base 2)) solution			
			
			if(i == 0) {
				result[i] = 0;
			} else if(i == 1 || i == 2) {
				result[i] = 1;
			} else {
				int one_count = 0;
				int temp = i;
				while(temp > 0) {
					
					if(temp % 2 == 1)
						one_count++;
					temp = temp / 2;
				}
				result[i] = one_count;
			} */
		
		
//		O(n) solution
		result[0] = 0;
		int pow = 1;
			
		for (int i = 1, t = 0; i <= num; i++, t++) {
			
			if(i == pow) {
				
				pow = pow * 2;
				t = 0;
				
			}
			result[i] = result[t] + 1;
			
		}
		
		return result;
	}
}
