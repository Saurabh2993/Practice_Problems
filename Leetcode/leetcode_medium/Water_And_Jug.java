package leetcode_medium;

public class Water_And_Jug {
	
	public static void main(String args[]) {
		
		int x = 5;
		int y = 3;
		int z = 4;
		Water_And_Jug w = new Water_And_Jug();
		System.out.println(w.canMeasureWater(x, y, z));
		
	}
	
	public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y) {
            return false;
        }
        if(z == x || z == y || z == x + y) {
            return true;
        }
        
        return z % gcd(x, y) == 0;
    }
    
    private int gcd(int a, int b) {
        
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }

}
