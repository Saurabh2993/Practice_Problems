package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Factorization {
	
	public static void main(String args[]) {
		
		int a = 11;
		
		smallestFactorization(a);
		
	}
	
	public static int smallestFactorization(int a) {
		
		if(a < 10)
			return a;
		
		List<Integer> divisor_list = new ArrayList<>();
		
		for (int i = 2; i < 10; i++) {
			if(a % i == 0)
				divisor_list.add(i);
		}
		
		Integer divisors[] = divisor_list.toArray(new Integer[divisor_list.size()]);
		
		int temp = a;
		int index = divisors.length - 1;
		StringBuilder sb = new StringBuilder();
		
		while(temp > 0 && index != -1) {
			
			if(temp % divisors[index] == 0) {
//				sb.append(divisors[index]);
				sb.insert(0, divisors[index]);
				temp = temp / divisors[index];
			} else {
				index--;
			}
		}
		
		if(sb.toString().equals(""))
			return 0;
		
		long ans = Long.parseLong(sb.toString());
		
		if(temp == 1 && ans < Integer.MAX_VALUE)
			return (int) ans;
		else
			return 0;
	}

}
