package leetcode_medium;

import test_Package.TreeNode;

public class Maximum_Binary_Tree {
	
	public static void main(String args[]) {
		
		int nums[] = {3,2,1,6,0,5};
		Maximum_Binary_Tree m = new Maximum_Binary_Tree();
		m.constructMaximumBinaryTree(nums);
		
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return helper(nums, 0, nums.length - 1);
        
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int max = nums[start];
        int max_pos = start;
        for(int i = start; i <= end; i ++) {
            if(max < nums[i]) {
                max = nums[i];
                max_pos = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, max_pos - 1);
        root.right = helper(nums, max_pos + 1, end);
        
        return root;
    }

}
