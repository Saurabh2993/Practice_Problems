package leetcode_easy;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

public class Keyboard_Row {
	
	public static void main(String args[]) {
		
		String[] input = {"hello", "alaska", "dad", "peace"};
		
		String ans[] = findWords(input);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
		
		
	}
	
	public static String[] findWords(String[] words) {
		
		String[] result = new String[words.length];
		
		String firstRow = "qwertyuiop";
		String secondRow = "asdfghjkl";
		String thirdRow = "zxcvbnm";
		
		int pointer = 0;
		
		for (int i = 0; i < result.length; i++) {
			
			if(words[i].length() == 1) {
				
				result[pointer] = words[i];
				pointer ++;
				
			} else {
			
				String currRow = null;
				for (int j = 0; j < words[i].length(); j++) {
					
					if(j == 0) {
						if(firstRow.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
							currRow = firstRow;
						} else if(secondRow.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
							currRow = secondRow;
						} else {
							currRow = thirdRow; 
						}
					} else {
						if(currRow.indexOf(words[i].toLowerCase().charAt(j)) == -1) {
							break;
						} else if(j == words[i].length() - 1) {
							result[pointer] = words[i];
							pointer ++;
						}
					}
				}
			}
		}
		
		return Arrays.copyOfRange(result, 0, pointer);
	}
}