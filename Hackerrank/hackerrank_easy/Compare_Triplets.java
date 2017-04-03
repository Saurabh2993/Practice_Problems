package hackerrank_easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Compare_Triplets {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
        int a[] = new int[3];
        int b[] = new int[3];
        
        a[0] = in.nextInt();
        a[1] = in.nextInt();
        a[2] = in.nextInt();
        b[0] = in.nextInt();
        b[1] = in.nextInt();
        b[2] = in.nextInt();
        
        int a_score = 0;
        int b_score = 0;
        
        for (int i = 0; i < 3; i++) {
        	
        	if(a[i] == b[i])
        		continue;
        	else if(a[i] > b[i])
        		a_score ++;
        	else
        		b_score ++;
			
		}
        
        System.out.println(a_score + " " + b_score);
        
	}

}
