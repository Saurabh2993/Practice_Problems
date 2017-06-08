package leetcode_easy;

public class Count_Segments {
	
	public static void main(String args[]) {
		
		String x = ", , , ,        a, eaefa";
		
		System.out.println(countSegments(x));
		
	}
	
	public static int countSegments(String s) {
		
		if(s.length() == 0)
			return 0;
		
		String x[] = s.split(" ");
		
		int count = 0;
		for(String str : x) {
			if(!str.equals(""))
				count ++;
		}
		
		return count;
	}

}
