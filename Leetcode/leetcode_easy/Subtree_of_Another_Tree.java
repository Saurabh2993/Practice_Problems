package leetcode_easy;

import test_Package.TreeNode;

public class Subtree_of_Another_Tree {
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
		
		return traverse(s, t);
		
	}
	
	private boolean traverse(TreeNode s, TreeNode t) {
		
		return (s != null) && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
		
	}
	
	private boolean equals(TreeNode s, TreeNode t) {
		
		if(s == null && t == null) {
			return true;
		} else if(s == null || t == null) {
			return false;
		} else {
			return (s.getValue() == t.getValue()) && equals(s.left, t.left) && equals(s.right, t.right); 
		}
		
	}

}
