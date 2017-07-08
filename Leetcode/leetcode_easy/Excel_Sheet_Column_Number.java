package leetcode_easy;

public class Excel_Sheet_Column_Number {
	
	public static void main(String args[]) {
		
		String text = "AB";
		Excel_Sheet_Column_Number x = new Excel_Sheet_Column_Number();
		x.titleToNumber(text);
		
	}
	
	public int titleToNumber(String s) {
        
        int multiplier = 1;
        int answer = 0;
        
        for(int i = s.length() - 1; i >= 0; i --) {
            answer += (s.charAt(i) - 'A' + 1) * multiplier;
            multiplier *= 26;
        }
        
        return answer;
    }

}
