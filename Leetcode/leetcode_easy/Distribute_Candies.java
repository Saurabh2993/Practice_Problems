package leetcode_easy;

import java.util.Arrays;
import java.util.HashSet;

public class Distribute_Candies {
	
	public static void main(String args[]) {
		
		int[] candies = {1, 2, 3, 2};
		
		int ans = distributeCandies(candies);
		System.out.println(ans);
		
	}
	
	public static int distributeCandies(int[] candies) {
		
/*		O(nlog(n)) solution using sorting		
		
		Arrays.sort(candies);
		
		int total_candies = candies.length;
		int sister_candies = 1;
		
		for (int i = 1; i < candies.length && sister_candies < total_candies / 2; i++) {
			
			if(candies[i - 1] == candies[i]) {
				continue;
			} else {
				sister_candies++;
			}
		}
		
		return sister_candies; */
		
//		O(n) solution using hashset
		
		HashSet<Integer> candy_types = new HashSet<>();
		for (int i = 0; i < candies.length; i++) {
			candy_types.add(candies[i]);
		}
		
		return Math.min(candy_types.size(), candies.length / 2);
		
	}

}
