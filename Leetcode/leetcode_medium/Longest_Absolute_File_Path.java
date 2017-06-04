package leetcode_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Longest_Absolute_File_Path {
	
	public static void main(String args[]) {
		
		String x = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"; ;
//		String x = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lengthLongestPath(x));
		
	}
	
	public static int lengthLongestPath(String input) {
		
		String[] split_path = input.split("\n");
//		Stack<String> st = new Stack<>();
		
		Stack<Integer> length_stack = new Stack<>();
		
		char tab = '\t';
		int current_level = 0;
		int prev_level = -1;
		
		int path_length = 0;
//		String path = "";
		int max_path_length = 0;
		
		for (int i = 0; i < split_path.length; i++) {
			
////			System.out.println(split_path[i]);
//			current_level = split_path[i].lastIndexOf(tab) + 1;
//			
//			if(prev_level + 1 != current_level) {
//				for (int j = prev_level; j >= current_level; j--) {
//					st.pop();
//					prev_level--;
//				}
//			}
//			st.push(split_path[i]);
//			prev_level = current_level;
////			System.out.println(Arrays.toString(st.toArray()));
//			System.out.println(current_level);
//			
//			
//			if(split_path[i].indexOf(".") != -1) {
//				path_length = 0;
////				path = "";
//				int count = 0;
//				for(String sub_path : st) {
//					System.out.println(sub_path);
//					path_length = path_length + sub_path.length() - count + 1;
//					count++;
////					path += sub_path;
//				}
//				path_length = path_length - 1;
//				System.out.println(path_length);
//				if(max_path_length < path_length) {
//					max_path_length = path_length;
			
//				}
//			}
			
			
// 			Faster Solution			
			current_level = split_path[i].lastIndexOf(tab) + 1;
			
			if(prev_level + 1 != current_level) {
				while(length_stack.size() != current_level) {
					length_stack.pop();
					prev_level--;
				}
			}
			prev_level = current_level;
			
			if(length_stack.size() == 0){
				path_length = split_path[i].length();
			} else {
				path_length = length_stack.peek();
				path_length = path_length + split_path[i].length() - current_level + 1;
			}
			length_stack.add(path_length);
			
			System.out.println(Arrays.toString(length_stack.toArray()));
			
			if(split_path[i].indexOf(".") != -1 && path_length > max_path_length) {
				max_path_length = path_length;
			}
			
		}
		
		return max_path_length;
		
	}

}
