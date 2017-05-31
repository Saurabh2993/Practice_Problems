package leetcode_easy;

public class Best_Buy_Sell {
	
	public static void main(String args[]) {
		
		int prices[] = {7, 6, 5, 4, 3, 2};
		
		int max_profit = maxProfit(prices);
		System.out.println(max_profit);
		
	}
	
	public static int maxProfit(int[] prices) {
		
		int max_profit = 0;
		int profit;
		
		if (prices.length == 0) {
			return 0;
		}
		
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			} else {
				profit = prices[i] - min;
				if (profit > max_profit) {
					max_profit = profit;
				}
			}
		}
		
		return max_profit;
    }
	
	public static int maxProfit2 (int[] prices) {
		
		int max_profit = 0;
		
		for (int i = 0; i < prices.length - 1; i++) {
			if(prices[i + 1] > prices[i])
				max_profit = max_profit + prices[i + 1] - prices[i];
		}
		
		return max_profit;
	}
}
