package hackerrank_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Very_Big_Sum {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		
		long sum = 0;
		String input_array[] = input.readLine().split(" ");
		
		for (int i = 0; i < input_array.length; i++) {
			
			sum = sum + Integer.parseInt(input_array[i]);
			
		}
		
		System.out.println(sum);
		
	}

}
