package leetcode_medium;

public class Container_With_Max_Area {
	
	public static void main(String args[]) {
		
		int height[] = {1, 2, 3, 2, 1, 1};
		Container_With_Max_Area c = new Container_With_Max_Area();
		System.out.println(c.maxArea(height));
		
	}
	
	public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;
        
        while(l < r) {
            int area = (r - l) * Math.min(height[r], height[l]);
            max = Math.max(max, area);
            
            if(height[r] > height[l]) {
                l ++;
            } else {
                r --;
            }
        }
        
        return max;
    }

}
