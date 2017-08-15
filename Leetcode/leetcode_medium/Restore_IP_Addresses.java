package leetcode_medium;

import java.util.List;
import java.util.ArrayList;

public class Restore_IP_Addresses {
	
	public static void main(String args[]) {
		
		String s = "010010";
		Restore_IP_Addresses r = new Restore_IP_Addresses();
		System.out.println(r.restoreIpAddresses(s));
		
	}
	
	public List<String> restoreIpAddresses(String s) {
        
		List<String> result = new ArrayList<>();
		buildIP(s, 0, result, "");
		return result;
		
    }
    
    private void buildIP(String input, int dec_count, List<String> result, String build) {
    	if(input.length() == 0) {
    		return;
    	}
        if(dec_count == 3) {
        	if(input.length() > 3) {
        		return;
        	} else if(input.length() > 1 && input.charAt(0) == '0') {
        		return;
        	}
            int rem = Integer.parseInt(input);
            if(rem < 0 || rem > 255) {
                return;
            }
            result.add(build + input);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i ++) {
            
            sb.append(input.charAt(i));
            if(Integer.parseInt(sb.toString()) > 255) {
            	break;
            }
            if(i == 1 && sb.charAt(0) == '0') {
            	break;
            }
            sb.append(".");
            System.out.println(build + sb.toString());
            buildIP(input.substring(i + 1), dec_count + 1, result, build + sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            
        }
    }
}
