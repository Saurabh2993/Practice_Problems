package leetcode_medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Genetic_Mutations {
	
	static int findMutationDistance(String start, String end, String[] bank) {
        
        char[] bases = {'A', 'C', 'T', 'G'};
        
        Queue<String> mutations = new LinkedList<>();
        Set<String> visited_mutations = new HashSet<>();
        Set<String> bank_set = new HashSet<>(Arrays.asList(bank));
		
        mutations.add(start);
		mutations.add(null);
        int distance = 0;
        
        do {
            String current = mutations.remove();
            
            if(current.equals(null)) {
                mutations.add(null);
                distance++;
                continue;
            } else if(current.equals(end)) {
                return distance;
            } else {
                
            	visited_mutations.add(current);
                StringBuilder sb = new StringBuilder();
                sb.append(current);
                
                for(int i = 0; i < current.length(); i ++) {
                	
                	char index_char = current.charAt(i);
                    char[] arr = current.toCharArray();
                    
                    for(char c : bases) {
                        if(c == index_char) {
                            continue;
                        }
                        
                        arr[i] = c;
                        String mutation = new String(arr);
                        
                        if(!visited_mutations.contains(mutation) && bank_set.contains(mutation)) {
                        	bank_set.remove(mutation);
                            mutations.add(mutation);
                        }
                    }
                    arr[i] = index_char;
                }
            }
        } while (mutations.size() > 1);
        
        return -1;
    }

}
