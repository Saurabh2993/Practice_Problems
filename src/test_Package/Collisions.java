package test_Package;

public class Collisions {
	
	public static void main(String args[]) {
		
		int speed[] = {2, 4, 5, 7, 1, 3, 6, 1, 6, 4, 10, 4};
		int target = 2;
		
		Collisions c = new Collisions();
		System.out.println(c.findCollisions(speed, target));
		
	}
	
	public int findCollisions(int[] speed, int target) {
		
		int collisions_count = 0;
		int target_speed = speed[target]; 
		
		for(int i = 0; i < speed.length; i ++) {
			if(i == target) {
				continue;
			} else if(i < target && speed[i] > target_speed) {
				collisions_count++;
			} else if(i > target && speed[i] < target_speed) {
				collisions_count++;
			}
		}
		
		return collisions_count;
	}

}
