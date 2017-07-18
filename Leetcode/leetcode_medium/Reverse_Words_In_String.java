package leetcode_medium;

public class Reverse_Words_In_String {
	
	public static void main(String args[]) {
		
		String s = " the sky is  blue";
		Reverse_Words_In_String r = new Reverse_Words_In_String();
		r.reverseWords(s);
		
	}
	
	public String reverseWords(String s) {
        
		String[] split_string = s.trim().split(" ");
        split_string = reverse(split_string);
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(i = 0; i < split_string.length - 1; i ++){
        	if(!split_string[i].equals("")) {
//        		System.out.println("------------" + split_string[i]);
        		sb.append(split_string[i]);
        		sb.append(" ");
        	}
        }
        sb.append(split_string[i]);
        
        return sb.toString();
    }
    
    private String[] reverse(String[] words) {
        
        int i = 0;
        int j = words.length - 1;
        
        while(i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        
        return words;
    }

}
