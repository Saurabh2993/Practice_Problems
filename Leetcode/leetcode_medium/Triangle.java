package leetcode_medium;

import java.util.List;
import java.util.ArrayList;

public class Triangle {
	
	public int minimumTotal(List<List<Integer>> triangle) {
        
        List<Integer> prev_list = new ArrayList<>();
        boolean first = true;
        
        for(List<Integer> l : triangle) {
            if(first) {
                prev_list = l;
                first = false;
                continue;
            }
            for(int index = 0; index < l.size(); index ++) {
                int min = findMinAdjacent(prev_list, index);
                int curr = l.get(index);
                l.set(index, curr + min);
            }
            
            prev_list = l;
        }
        
        // System.out.println(prev_list);
        int min = Integer.MAX_VALUE;
        for(int i : prev_list) {
            min = Math.min(min, i);
        }
        return min;
    }
	
	private int findMinAdjacent(List<Integer> prev_list, int index) {
        if(index == 0) {
            return prev_list.get(index);
        } else if(index == prev_list.size()) {
            return prev_list.get(index - 1);
        } else {
            return Math.min(prev_list.get(index - 1), prev_list.get(index));
        }
		
	}
}