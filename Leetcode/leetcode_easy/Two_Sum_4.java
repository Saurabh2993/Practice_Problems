package leetcode_easy;

import java.util.List;
import java.util.ArrayList;
import test_Package.TreeNode;

public class Two_Sum_4 {
	
	List<Integer> nums = new ArrayList<>();
    
    public boolean findTarget(TreeNode root, int k) {
        
        inOrder(root);
        System.out.println(nums);
        
        int start = 0;
        int end = nums.size() - 1;
        
        while(start < end) {
            if(nums.get(start) + nums.get(end) == k) {
                return true;
            } else if(nums.get(start) + nums.get(end) < k) {
                start++;
            } else {
                end--;
            }
        }
        
        return false;
    }
    
    private void inOrder(TreeNode root) {
        
        if(root == null) {
            return;
        }
        inOrder(root.left);
        nums.add(root.getValue());
        inOrder(root.right);
        
        
    }

}
