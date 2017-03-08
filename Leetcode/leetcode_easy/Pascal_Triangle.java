package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
	
	public static void main(String args[]) {
		
		int numRows = 6;
		
		List<List<Integer>> ans_list = generate(numRows);
		
		System.out.println(ans_list);
		
	}
	
	public static List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> ans_list = new ArrayList<>();
		
		for(int i = 1; i <= numRows; i++) {
			
			List<Integer> list = new ArrayList<Integer>();
//			System.out.println(i);
			if (i == 1) {
				list.add(1);
				ans_list.add(list);
			}
			else {
				List<Integer> old_list = ans_list.get(i - 2);
				
				list.add(1);
				
				for (int j = 0; j < old_list.size() - 1; j ++) {
					list.add(old_list.get(j) + old_list.get(j + 1));
				}

				list.add(1);
				ans_list.add(list);
			}
		}
		
        return ans_list;
    }

}
