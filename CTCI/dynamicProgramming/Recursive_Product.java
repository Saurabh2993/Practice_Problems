package dynamicProgramming;

public class Recursive_Product {
	
	public static void main(String args[]) {
		
		Recursive_Product r = new Recursive_Product();
		int x = r.getProduct(31, 31);
		System.out.println(x);
		
	}
	
	
	public int getProduct(int a, int b) {
		int smaller = a < b ? a : b;
		int bigger = a > b ? a : b;
		
		return productHelper(smaller, bigger);
	}
	
	private int productHelper(int smaller, int bigger) {
		if(smaller == 0) {
			return 0;
		} else if(smaller == 1) {
			return bigger;
		}
		
		int half = smaller >> 1;
		int halfProduct = productHelper(half, bigger);
		
		if(smaller % 2 == 0) {
			return halfProduct + halfProduct;
		} else {
			return halfProduct + halfProduct + bigger;
		}
		
		
	}

}
