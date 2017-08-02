package leetcode_easy;

public class Power_Of_Four {
	
	public static void main(String args[]) {
		
		int num = 16;
		Power_Of_Four p = new Power_Of_Four();
		System.out.println(p.isPowerOfFour(num));
		
	}
	
	
	public boolean isPowerOfFour(int num) {
        if(num <= 0) {
            return false;
        }
        
        /*else if (num == 1) {
        	return true;
        }
        
        String n = Integer.toBinaryString(num);
        
        if(n.charAt(0) == '1' && ((n.length() - 1) % 2 == 0) && (n.substring(1).lastIndexOf("1") == -1)) {
            return true;
        } else {
            return false;
        }*/
        
        if(((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0)) {
        	return true;
        }
        
        return false;
    }

}
