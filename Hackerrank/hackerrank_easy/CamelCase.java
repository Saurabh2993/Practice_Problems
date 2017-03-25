package hackerrank_easy;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CamelCase {
	
	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        String s = in.next();
        
        
        ConcurrentHashMap<Integer, Integer> x = new ConcurrentHashMap<>();
        
        
//        A = 65, Z = 90
        
        int count = 0;
        
        char[] c = s.toCharArray();
        
        if(c.length == 0)
        	System.out.println(count);
        else {
        	count++;
        	for (int i = 0; i < c.length; i++) {
        		if((int)c[i] >= 65 && (int)c[i] <= 90) {
        			count++;
        		}
        	}
        	System.out.println(count);
        }
	}
}
