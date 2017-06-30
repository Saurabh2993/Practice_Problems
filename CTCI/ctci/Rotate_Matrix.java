package ctci_easy;

public class Rotate_Matrix {
	
	public static void main(String args[]) {
		
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------");
		
		rotateMatrix(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] rotateMatrix(int[][] matrix) {
		
		if(matrix.length == 0 || matrix.length == 1 || matrix.length != matrix[0].length)
			return matrix;
			
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			
			int first = layer;
			int last = n - layer - 1;
			
			for (int i = first; i < last; i++) {
				
				int offset = i - first;			//important
				int temp = matrix[first][i];
				
				//left -> top
				matrix[first][i] = matrix[last - offset][first];
				
				//bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				//right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				//top -> right
				matrix[i][last] = temp;
				
			}
		}
		
		return matrix;
	}
	
}