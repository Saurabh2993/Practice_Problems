package leetcode_easy;

public class Length_Of_Last_Word {
	
	public static void main(String args[]) {
		
		String s = "Hello World ";
		Length_Of_Last_Word l = new Length_Of_Last_Word();
		System.out.println(l.lengthOfLastWord(s));
		
	}
	
	public int lengthOfLastWord(String s) {
        
		int len = 0;
		boolean foundWord = false;
		
		for(int i  = s.length() - 1; i >= 0; i --) {
			if(s.charAt(i) == ' ') {
				if(foundWord) {
					break;
				}
			} else {
				foundWord = true;
				len++;
			}
		}
		
		return len;
    }

}
