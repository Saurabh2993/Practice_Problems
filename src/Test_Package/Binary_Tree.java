package Test_Package;

public class Binary_Tree {
	
	public static void main (String args[]) {
		
		new Binary_Tree().run();
		
	}

	public void run() {
		
		TreeNode root = new TreeNode(4);
		System.out.println("Building tree with root value " + root.value);
		insert(root, 2);
		insert(root, 7);
		insert(root, 1);
		insert(root, 3);
		insert(root, 6);
//		insert(root, 9);
		
		invertTree(root);
		
		printInOrder(root);
		
		
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
}
