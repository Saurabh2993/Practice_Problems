package ctci;

public class Rotation_SubString {
	
	public static void main(String args[]) {
		
		String s = "waterbottle";
		String t = "erbottlewa";
//		System.out.println(isSubstring("waterer", s));
		
		System.out.println(isRotationSubstring(s, t));
		
	}
	
	public static boolean isSubstring(String x, String y) {
		
		if(y.indexOf(x) != -1)
			return true;
		else
			return false;
		
	}
	
	public static boolean isRotationSubstring(String s, String t) {
		
		if(s.length() != t.length())
			return false;
		
		String temp = t + t;
		
		return isSubstring(s, temp);
		
	}

}
