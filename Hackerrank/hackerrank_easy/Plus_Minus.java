package hackerrank_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus_Minus {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int curr = 0;
		double zero_count = 0;
		double plus_count = 0;
		double minus_count = 0;
		
		String input_array[] = input.readLine().split(" ");
		
		for (int i = 0; i < input_array.length; i++) {
			
			curr = Integer.parseInt(input_array[i]);
			if(curr == 0)
				zero_count ++;
			else if (curr < 0)
				minus_count ++;
			else
				plus_count ++;
			
		}
		
		System.out.println(plus_count / n);
		System.out.println(minus_count / n);
		System.out.println(zero_count / n);
		
	}
}
