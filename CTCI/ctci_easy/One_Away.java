package ctci_easy;

public class One_Away {
	
	public static void main(String args[]) {
		
		String s = "pale";
		String t = "ble";
		
		System.out.println(oneEditAway(s, t));
		
	}
	
	public static boolean oneEditAway(String s, String t) {
		
		if(Math.abs(s.length() - t.length()) > 1) {
			return false;
		}
		
		String s1 = s.length() < t.length() ? s : t;
		String s2 = s.length() < t.length() ? t : s;
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index1 < s1.length() && index2 < s2.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(foundDifference) {
					return false;
				}
				foundDifference = true;
				
				if(s1.length() == s2.length()) {
					index1++;
				}
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}

}
