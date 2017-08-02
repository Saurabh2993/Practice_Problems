package leetcode_medium;

public class String_To_Int {
	
	public static void main(String args[]) {
		
		String_To_Int s = new String_To_Int();
		System.out.println(s.myAtoi("123456"));
		
	}
	
	public int myAtoi(String str) {
        
		String trim_str = str.trim();
        boolean neg = false;
        boolean num_found = false;
        boolean sign_found = false;
        long value = 0;
        
        for(int i = 0; i < trim_str.length(); i ++) {
        	
        	char c = trim_str.charAt(i);
        	
        	if((c == '-' || c == '+') && !num_found) {
        		if(!sign_found) {
        			sign_found = true;
        		} else {
        			break;
        		}
        		neg = c == '-' ? true : false;
        	} else if((c - '0') >= 0 && (c - '0') <= 9) {
        		if(!num_found) {
        			num_found = true;
        		}
                long prev_value = value;
        		value = value * 10 + (c - '0');
                if(prev_value > value) {
                    if(neg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
        	} else {
                break;
            }
        	
        }
		
        if(neg) {
        	value = -value;
        }
        if(value > Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }
        
        return (int) value;
        
    }

}
