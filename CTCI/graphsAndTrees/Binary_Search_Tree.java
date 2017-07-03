package graphsAndTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Search_Tree {
	
	TreeNode root;
	
	public Binary_Search_Tree() {
		root = null;
	}
	
	public void insert(int value) {
		
//		System.out.println(value);
		
		if(root == null) {
			root = new TreeNode(value);
			return;
		}
		
		insert(root, value);
		
	}
	
	public void insert(TreeNode node, int value) {
		
		if(value < node.value) {
			if(node.left != null) {
				insert(node.left, value);
			} else {
				node.left = new TreeNode(value);
			}
		} else if(value > node.value) {
			if(node.right != null) {
				insert(node.right, value);
			} else {
				node.right = new TreeNode(value);
			}
		}
	}
	
	public void printInOrder(TreeNode node) {
		
		if(node != null) {
			printInOrder(node.left);
			System.out.println(node.value);
			printInOrder(node.right);
		}
	}
	
	public List<List<Integer>> printLevelOrder(TreeNode node) {
		
		List<List<Integer>> all_elements = new ArrayList<>();
        
        if(node == null)
            return all_elements;
        
        Queue<TreeNode> elements_queue = new LinkedList<>();
		elements_queue.add(node);
		elements_queue.add(null);
		
		List<Integer> temp_list = new ArrayList<>();
		do {
			
			node = elements_queue.remove();
			if(node == null) {
				elements_queue.add(null);
//				System.out.println(Arrays.asList(temp_list));
				all_elements.add(temp_list);
				temp_list = new ArrayList<>();
				continue;
			}
			
			temp_list.add(node.value);
// 			System.out.print(node.value + " ");
			if(node.left != null) {
				elements_queue.add(node.left);
			}
			if(node.right != null) {
				elements_queue.add(node.right);
			}
		} while (elements_queue.size() > 1);
		
		all_elements.add(temp_list);
		
		return all_elements;
	}
	
	public List<List<TreeNode>> depthWiseListOfNodes(TreeNode node) {
		
		List<List<TreeNode>> result = new LinkedList<List<TreeNode>>();
		
		List<TreeNode> current = new LinkedList<>();
		if(node != null)
			current.add(node);
		
		while(current.size() > 0) {
			
			result.add(current);
			List<TreeNode> parents = current;
			current = new LinkedList<>();
			
			for(TreeNode t : parents) {
				if(t.left != null)
					current.add(t.left);
				if(t.right != null)
					current.add(t.right);
			}
		}
		
		return result;
	}

}
