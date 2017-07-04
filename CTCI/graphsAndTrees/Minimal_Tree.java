package graphsAndTrees;

import java.util.Arrays;
import java.util.List;

public class Minimal_Tree {
	
	Binary_Search_Tree bst = new Binary_Search_Tree();
	
	public static void main(String args[]) {
		
		int nums[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		
		Minimal_Tree mt = new Minimal_Tree();
		mt.createMinimalTree(nums);
		
		
	}
	
	public void createMinimalTree(int nums[]) {
		
		int low = 0;
		int high = nums.length - 1;
		
		insertNodes(nums, low, high);
		
//		bst.printInOrder(bst.root);
		System.out.println(bst.isBalanced(bst.root));
		/*List<List<TreeNode>> x = bst.depthWiseListOfNodes(bst.root);
		for(List<TreeNode> t : x) {
			for(TreeNode curr : t) {
				System.out.print(curr.value + " ");
			}
			System.out.println();
		}*/
		
	}
	
	private void insertNodes(int nums[], int low, int high) {

		if(low <= high) {
			int mid = (low + high) / 2;
			bst.insert(nums[mid]);
			
			insertNodes(nums, low, mid - 1);
			insertNodes(nums, mid + 1, high);
		}
	}

}
