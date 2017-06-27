package leetcode_medium;

public class Coin_Change {
	
	public static void main(String args[]) {
		
		int coins[] = {1, 2, 5};
		int amount = 11;
		
		Coin_Change cc = new Coin_Change();
		
		System.out.println(cc.minCoins(coins, amount));
	}
	
	public int minCoins(int coins[], int amount) {
		
		int min[] = new int[amount + 1];
		min[0] = 0;
		
		for (int i = 1; i <= amount; i++) {
			min[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j < coins.length; j++) {
				if(i >= coins[j] && min[(i - coins[j])] != Integer.MAX_VALUE) {
					min[i] = Math.min(min[i], min[(i - coins[j])] + 1);
				}
			}
			
		}
		
		if(min[amount] == Integer.MAX_VALUE)
			return -1;
		else
			return min[amount];
	}
	
	

}
