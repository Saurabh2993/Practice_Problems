package Test_Package;

public class Binary_Tree {
	
	public static void main (String args[]) {
		
		new Binary_Tree().run();
		
	}

	public void run() {
		
		TreeNode root = new TreeNode(4);
//		System.out.println("Building tree with root value " + root.value);
		insert(root, 2);
		insert(root, 7);
		insert(root, 1);
		insert(root, 3);
		insert(root, 6);
//		insert(root, 9);
		
		invertTree(root);
		
//		printInOrder(root);
		System.out.println(maxDepth(root));
		
		
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
		} else if(node.left != null && node.right == null) {
			int left_depth = maxDepth(node.left);
			return left_depth + 1;
		} else if(node.left == null && node.right != null) {
			int right_depth = maxDepth(node.right);
			return right_depth + 1;
		} else {
			int left_depth = maxDepth(node.left);
			int right_depth = maxDepth(node.right);
			return Math.max(left_depth, right_depth) + 1;
		}
	}
}
