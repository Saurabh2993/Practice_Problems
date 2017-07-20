package dynamicProgramming;

public class TripleStep {
	
	public static void main(String args[]) {
		
		int n = 6;
		TripleStep t = new TripleStep();
		System.out.println(t.findMinSteps(n));
		
	}

	
	public int findMinSteps(int n) {
		
		int[] min_steps = new int[n + 1];
		min_steps[0] = 1;
		
		for(int i = 1; i <= n; i ++) {
			int total = 0;
			for(int j = 1; j <= 3; j ++) {
				if(i < j) {
					break;
				}
				total += min_steps[i - j];
			}
			min_steps[i] = total;
//			System.out.println(i + "  " + total);
		}
		
		return min_steps[n];
	}
}
