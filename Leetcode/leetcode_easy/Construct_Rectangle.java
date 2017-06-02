package leetcode_easy;

public class Construct_Rectangle {
	
	public static void main(String args[]) {
		
		int area = 0;
		
		System.out.println(constructRectangle(area)[0] + " " + constructRectangle(area)[1]);
		
		
	}
	
	public static int[] constructRectangle(int area) {
		
		int[] dimensions = new int[2];
		
		for (int i = (int) Math.sqrt(area); i >= 1; i--) {
			
			int width = i;
			int length = area / width;
			
			if(width * length == area) {
				dimensions[0] = length;
				dimensions[1] = width;
				break;
			} else {
				continue;
			}
		}
		
		return dimensions;
	}

}
