package hackerrank_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_Sum {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		
		int sum = 0;
		String input_array[] = input.readLine().split(" ");
		
		
		for(int i = 0; i < n; i++) {
			
			sum = sum + Integer.parseInt(input_array[i]);
			
		}
		
		System.out.println(sum);
		
	}

}
