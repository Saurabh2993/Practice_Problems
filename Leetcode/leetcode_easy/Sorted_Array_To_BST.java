package leetcode_easy;

import test_Package.TreeNode;

public class Sorted_Array_To_BST {
	
	public static void main(String args[]) {
		
		int[] nums = {1,2,3,4,5};
		Sorted_Array_To_BST s = new Sorted_Array_To_BST();
		s.sortedArrayToBST(nums);
		
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = buildTree(nums, start, mid - 1);
        node.right = buildTree(nums, mid + 1, end);
        
        return node;
    }

}
