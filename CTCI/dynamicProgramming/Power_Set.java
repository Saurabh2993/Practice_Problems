package dynamicProgramming;

import java.util.List;
import java.util.ArrayList;

public class Power_Set {
	
	public static void main(String args[]) {
		
		int n[] = {1, 2, 3};
		Power_Set p = new Power_Set();
		
		List<String> l1 = new ArrayList<String>();
		/*l1.add("Hello");
		l1.add("World");
		List<String> l2 = new ArrayList<String>(l1); //A new arrayList.
		l2.add("Everybody");
		
		System.out.println(l1);
		System.out.println(l2);*/
		
		p.getPowerSet(n);
		
	}
	
	public List<List<Integer>> getPowerSet(int n[]) {
		
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		answer.add(temp);
		System.out.println(answer);
		
		for(int i : n) {
			List<List<Integer>> copy = new ArrayList<List<Integer>>(answer);
			for(List<Integer> list : copy) {
				List<Integer> copy_list = new ArrayList<>(list);
				copy_list.add(i);
				answer.add(copy_list);
			}
		}
		
		System.out.println(answer);
		return answer;
	}

}
