package test_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree {
	
	public static void main (String args[]) {
		
		new Binary_Tree().run();
		
	}

	public void run() {
		
		TreeNode root = new TreeNode(3);
//		System.out.println("Building tree with root value " + root.value);
		insert(root, 2);
		insert(root, 1);
		insert(root, 15);
		insert(root, 7);
		insert(root, 6);
		insert(root, 9);
		
//		List<Integer> arr = new ArrayList<>();
//		
//		getArray(root, arr);
//		
//		System.out.println(Arrays.asList(arr));
//		
//		int prev = 0;
//		int count = 0;
//		boolean first = true;
//		
//		int val1, val2;
//		
//		for (int i : arr) {
//			 if(count == 0) {
//				 prev = i; 
//			 }
//			 count++;
//			 if(prev > i) {
//				 if(arr.size() == 2) {
//					val1 = prev;
//					val2 = i;
//					break;
//				 }
//				 
//				 if(first) {
//					 val1 = prev;
//					 first = false;
//				 } else {
//					 val2 = i;
//					 break;
//				 }
//			 }
//		}
		
		
		
		
		
//		invertTree(root);
//		printInOrder(root);
//		printLevelOrder(root);
//		System.out.println(maxDepth(root));
		
//		treePaths(root);
		
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
	
//	public void getArray(TreeNode node, List<Integer> arr) {
//		
//		if(node != null) {
//			getArray(node.left, arr);
//			arr.add(node.value);
//			getArray(node.right, arr);
//		}
//		
//	}
	
	public List<String> treePaths(TreeNode node) {
		
		List<String> answer_list = new ArrayList<>();
		if(node != null) {
			findNext(node, answer_list, "");
		}
		System.out.println(Arrays.asList(answer_list));
		return answer_list;
	}
	
	public void findNext(TreeNode node, List<String> answer, String path) {
		System.out.println(path);
		if(node.left != null) {
			String temp = path + node.value + "->";
			findNext(node.left, answer, temp);
		}
		if(node.right != null) {
			String temp = path + node.value + "->";
			findNext(node.right, answer, temp);
		}
		if(node.left == null && node.right == null) {
			String temp = path + node.value;
			answer.add(temp);
		}
	}
	
	
	
	public List<List<Integer>> printLevelOrder(TreeNode node) {
		
		List<List<Integer>> all_elements = new ArrayList<>();
        
        if(node == null)
            return all_elements;
        
        Queue<TreeNode> elements_queue = new LinkedList<>();
		elements_queue.add(node);
		elements_queue.add(null);
		
		List<Integer> temp_list = new ArrayList<>();; 
		do {
			
			node = elements_queue.remove();
			if(node == null) {
				elements_queue.add(null);
				// System.out.println(Arrays.asList(temp_list));
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
	
	
	public void invertTree(TreeNode node) {
		
		if(node != null) {
        
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if(node.left != null) {
				invertTree(node.left);
			}
			if(node.right != null) {
				invertTree(node.right);
			}
		}
	}
	
	public int maxDepth(TreeNode node) {
		
		if(node == null)
            return 0;
		
		if(node.left == null && node.right == null) {
			return 1;
		} else {
			int left_depth = maxDepth(node.left);
			int right_depth = maxDepth(node.right);
			return Math.max(left_depth, right_depth) + 1;
		}
	}
}
