package leetcode_easy;

public class Count_Primes {
	
	public static void main(String args[]) {
		
		System.out.println(countPrimes(1500000));
		
	}
	
	public static int countPrimes(int n) {
		
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if(!notPrime[i]) {
				count++;
				
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		
		return count;
	}

}