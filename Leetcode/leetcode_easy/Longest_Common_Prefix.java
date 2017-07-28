package leetcode_easy;

public class Longest_Common_Prefix {
	
	public static void main(String args[]) {
		
		String strs[] = {"flower","flow","flight"};
		Longest_Common_Prefix l = new Longest_Common_Prefix(); 
		System.out.println(l.longestCommonPrefix(strs));
		
	}
	
	public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) {
            return "";
        } else if(strs.length == 1) {
            return strs[0];
        }
        
        String answer = strs[0];
        int len = answer.length();
        
        for(int i = 1; i < strs.length; i ++) {
//            System.out.println(answer);
            len = Math.min(len, strs[i].length());
            if(strs[i].substring(0, len) == answer) {
                continue;
            } else {
//                System.out.println("--------------");
                while(len > 0) {
//                    System.out.println(answer.substring(0, len));
//                    System.out.println(strs[i].substring(0, len));
                    if(answer.substring(0, len).equals(strs[i].substring(0, len))) {
                        answer = answer.substring(0, len);
                        break;
                    }
                    len --;
                }
                
                if(len == 0) {
                    return "";
                }
            }
        }
        
        return answer;
    }

}
