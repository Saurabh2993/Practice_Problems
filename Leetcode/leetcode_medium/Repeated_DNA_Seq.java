package leetcode_medium;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Repeated_DNA_Seq {
	
	public static void main(String args[]) {
		
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		Repeated_DNA_Seq r = new Repeated_DNA_Seq();
		r.findRepeatedDnaSequences(s);
		
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
        
		HashSet<String> repeated = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        
        for(int i = 0; i < s.length() - 10; i ++) {
            String curr = s.substring(i, i + 10);
            if(!seen.add(curr)) {
            	repeated.add(curr);
            }
        }
        
        // System.out.println(repeated);
        
        return new ArrayList<>(repeated);
        
    }

}
