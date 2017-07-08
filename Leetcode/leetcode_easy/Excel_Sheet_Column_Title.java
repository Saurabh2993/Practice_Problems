package leetcode_easy;

public class Excel_Sheet_Column_Title {
	
	public static void main(String args[]) {
		
		int n = 701;
		Excel_Sheet_Column_Title x = new Excel_Sheet_Column_Title();
		System.out.println(x.convertToTitle(n));
		
	}
	
	public String convertToTitle(int n) {
        
        StringBuilder answer = new StringBuilder();
        
        while(n > 0) {
            n--;
            int offset = n % 26;
            
            answer.insert(0, (char)('A' + offset));
            
            n = n / 26;
        }
        
        return answer.toString();
    }

}
