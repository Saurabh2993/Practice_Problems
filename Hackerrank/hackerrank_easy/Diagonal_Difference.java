package hackerrank_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Diagonal_Difference {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int a[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				a[i][j] = in.nextInt(); 
				
			}
			
		}
		
		int prim_diag_sum = 0;
		int seco_diag_sum = 0;
		
		for (int i = 0; i < n; i++) {
			
			prim_diag_sum = prim_diag_sum + a[i][i];
			seco_diag_sum = seco_diag_sum + a[i][n - i - 1];
			
		}
		
		System.out.println(Math.abs(prim_diag_sum - seco_diag_sum));
		
		
		
	}

}
