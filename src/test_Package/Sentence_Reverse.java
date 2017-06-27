package test_Package;

import java.util.Stack;

public class Sentence_Reverse {
	
	public static void main(String args[]) {
		
		char arr[] = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
		Sentence_Reverse sr = new Sentence_Reverse();
		
		char rev[] = sr.reverseWords(arr);
		
		for(char x : rev) {
			System.out.print(x);
		}
	}
	
	public char[] reverseWords(char arr[]) {
		
		if(arr.length == 0|| arr.length == 1) {
			return arr;
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<String> words = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != ' ') {
				sb.append(arr[i]);
			} else {
				words.push(sb.toString());
				words.push(" ");
				sb.delete(0, sb.length());
			}
		}
		
		words.push(sb.toString());
		sb.delete(0, sb.length());
		
		while(!words.isEmpty()) {
			sb.append(words.pop());
		}
		
		arr = sb.toString().toCharArray();
		
		return arr;
	}

}
