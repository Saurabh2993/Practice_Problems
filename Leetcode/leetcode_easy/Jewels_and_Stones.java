package leetcode_easy;

import java.util.HashSet;
import java.util.Set;

public class Jewels_and_Stones {

    public static void main(String[] args) {
        Jewels_and_Stones js = new Jewels_and_Stones();
        System.out.println(js.numJewelsInStones("aA", "aAAbbbb"));
    }

    private int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0) {
            return 0;
        }

        int jewels = 0;
        Set<Character> jewel_types = new HashSet<>();

        for(int i = 0; i < J.length(); i ++) {
            jewel_types.add(J.charAt(i));
        }

        for(int i = 0; i < S.length(); i ++) {
            if(jewel_types.contains(S.charAt(i))) {
                jewels ++;
            }
        }

        return jewels;
    }
}
