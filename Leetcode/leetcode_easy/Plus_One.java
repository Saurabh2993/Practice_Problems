package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plus_One {
	
	public static void main(String args[]) {
		
		int[] digits = {1, 0};
		
		System.out.println(Arrays.toString(plusOne(digits)));
		
	}
	
	public static int[] plusOne(int[] digits) {
		
//		int carry = 0;
//		int temp = 0;
//		List<Integer> result_list = new ArrayList<>();
//		for (int i = digits.length - 1; i >= 0; i--) {
//			
//			if(i == digits.length - 1 || carry == 1) {
//				 temp = digits[i] + 1;
//			} else {
//				temp = digits[i];
//			}
//			
//			if(temp == 10) {
//				result_list.add(0);
//				carry = 1;
//			} else {
//				result_list.add(temp);
//				carry = 0;
//			}
//		}
//		
//		if(carry == 1)
//			result_list.add(1);
//		
//		int[] result = new int[result_list.size()];
//		
//		int j = result_list.size();
//		for(int i : result_list){
//			result[j - 1] = i;
//			j--;
//		}
//		
//		System.out.println(Arrays.toString(result));
//		
//		
//		return result;
		
		
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		
		int[] answer = new int[digits.length + 1];
		answer[0] = 1;
		
		return answer;
	}

}
