package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers {

    public static void main(String args[]) {

        int left = 1;
        int right = 22;

        Self_Dividing_Numbers s = new Self_Dividing_Numbers();

        System.out.println(s.selfDividingNumbers(left, right));

    }

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> answer = new ArrayList<>();

        for(int i = left; i <= right; i ++) {
            if(checkSD(i)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private boolean checkSD(int n) {

        int temp = n;
        while(temp != 0) {

            int d = temp % 10;
            if(d == 0) {
                return false;
            }

            if(n % d != 0) {
                return false;
            }

            temp = temp / 10;
        }

        return true;
    }

}
