package test_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree {
	
	TreeNode root;
	
	public static void main (String args[]) {
		
		Binary_Tree tree1 = new Binary_Tree();
		tree1.run();
		Binary_Tree tree2 = new Binary_Tree();
		tree2.run1();
		
		
		Binary_Tree temp = new Binary_Tree();
		TreeNode new_root = temp.mergeTrees(tree1.root, tree2.root);
		List<List<Integer>> temp_list = temp.printLevelOrder(new_root);		
		System.out.println(Arrays.asList(temp_list));
		
	}

	private void run1() {
		// TODO Auto-generated method stub
		root = new TreeNode(6);
		insert(root, 3);
		insert(root, 2);
		insert(root, 15);
		insert(root, 7);
		List<List<Integer>> temp_list = printLevelOrder(root);		
		System.out.println(Arrays.asList(temp_list));
		
	}

	public void run() {
		
		root = new TreeNode(3);
//		System.out.println("Building tree with root value " + root.value);
		insert(root, 2);
		insert(root, 1);
		insert(root, 15);
		insert(root, 7);
		insert(root, 6);
		insert(root, 9);
		List<List<Integer>> temp_list = printLevelOrder(root);		
		System.out.println(Arrays.asList(temp_list));
		
		/*List<Integer> arr = new ArrayList<>();
		
		getArray(root, arr);
		
		System.out.println(Arrays.asList(arr));
		
		int prev = 0;
		int count = 0;
		boolean first = true;
		
		int val1, val2;
		
		for (int i : arr) {
			 if(count == 0) {
				 prev = i; 
			 }
			 count++;
			 if(prev > i) {
				 if(arr.size() == 2) {
					val1 = prev;
					val2 = i;
					break;
				 }
				 
				 if(first) {
					 val1 = prev;
					 first = false;
				 } else {
					 val2 = i;
					 break;
				 }
			 }
		}*/
		
		
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
	
	public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
		
		TreeNode root;
		if(node1 != null && node2 != null) {
			System.out.println(node1.value + node2.value);
			root = new TreeNode(node1.value + node2.value);
			root.left = mergeTrees(node1.left, node2.left);
			root.right = mergeTrees(node1.right, node2.right);
			
			return root;
		}
		else if(node1 == null && node2 != null) {
			root = new TreeNode(node2.value);
			root.left = mergeTrees(null, node2.left);
			root.right = mergeTrees(null, node2.right);
			
			return root;
		}
		else if(node1 != null && node2 == null) {
			root = new TreeNode(node1.value);
			root.left = mergeTrees(node1.left, null);
			root.right = mergeTrees(node1.right, null);
			
			return root;
		}
			
		else return null;
			
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
