package leetcode_medium;

public class Max_Prod_Words_Length {
	
	public static void main(String args[]) {
		
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		Max_Prod_Words_Length m = new Max_Prod_Words_Length();
		System.out.println(m.maxProduct(words));
		
	}
	
//	Brute Force
	/*public int maxProduct(String[] words) {
        
        int n  = words.length;
        boolean common = false;
        int max_prod = Integer.MIN_VALUE;
        
        for(int i = 0; i < n - 1; i ++) {
            
            for(int j = i + 1; j < n; j ++) {
                
                common = false;
                String curr1 = words[i];
                String curr2 = words[j];
                
                for(int k = 0; k < curr1.length(); k ++) {
                    char c = curr1.charAt(k);
                    if(curr2.lastIndexOf(c) != -1) {
                        common = true;
                        break;
                    }
                }
                
                if(!common) {
                    max_prod = max_prod > (curr1.length() * curr2.length()) ? max_prod : (curr1.length() * curr2.length());
                }
            }
        }
        
        if(max_prod < 0) {
            return 0;
        } else {
            return max_prod;
        }
    }*/
	
//	Bit manipulation solution
	public int maxProduct(String[] words) {
        
        int n = words.length;
        int max_prod = 0;
        
        int bit_map[] = new int[n];
        
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < words[i].length(); j++) {
                
                int c = words[i].charAt(j) - 97;
                bit_map[i] = bit_map[i] | (1 << c);
                
            }
        }
        
        for(int i = 0; i < n - 1; i ++) {
            for(int j = i + 1; j < n; j ++) {
                
                if((bit_map[i] & bit_map[j]) == 0) {
                    max_prod = max_prod > (words[i].length() * words[j].length()) ? max_prod : (words[i].length() * words[j].length());
                }
                
            }
        }
        
        return max_prod;
   }

}
