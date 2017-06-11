package orderExecution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class OrderBook {
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		HashMap<Integer, String> orders_map = new HashMap<>();
		int order_number = 1;
		while (input.hasNextLine()) {
			orders_map.put(order_number++, input.nextLine());
		}
		
		processOrders(orders_map);
	}
	
	private static void processOrders(HashMap<Integer, String> orders_map) {
		
		HashMap<Integer, String> buy_orders = new HashMap<>();
		HashMap<Integer, String> sell_orders = new HashMap<>();
		
		for(Integer key : orders_map.keySet()) {
			
			String order = orders_map.get(key);
			String[] order_details = order.split(" ");
			
			if(order_details[1].equals("buy")) {
				buy_orders.put(key, order);
			}
			
			if(order_details[1].equals("sell")) {
				sell_orders.put(key, order);
			}
		}
		
		Double[] buy_prices = sortBuyPrices(buy_orders);
		
		ArrayList<Integer> cancelled_orders_list = new ArrayList<>();
		ArrayList<Integer> cancelled_orders_instance = new ArrayList<>();
		cancelledOrders(orders_map, cancelled_orders_list, cancelled_orders_instance);
		
		Integer[] cancelled_orders_array = new Integer[cancelled_orders_list.size()];
		Integer[] cancelled_orders_instance_array = new Integer[cancelled_orders_list.size()];
		
		cancelled_orders_array = cancelled_orders_list.toArray(cancelled_orders_array);
		cancelled_orders_instance_array = cancelled_orders_instance.toArray(cancelled_orders_instance_array);
		
		for (int i = buy_prices.length - 1; i >= 0; i--) {
			for(Integer key : orders_map.keySet()) {
				String order = orders_map.get(key);
				if(!order.equals("")) {
					String[] order_details = order.split(" ");
					if(order_details[1].equals("buy") && Double.parseDouble(order_details[3]) == buy_prices[i]) {
						matchOrder(orders_map, buy_orders, sell_orders, order_details, cancelled_orders_array, cancelled_orders_instance_array, key);
					}
				}				
			}
		}
	}
	
	private static Double[] sortBuyPrices(HashMap<Integer, String> buy_orders) {
		
		ArrayList<Double> prices = new ArrayList<>(); 
		for(Integer key : buy_orders.keySet()) {
			String order = buy_orders.get(key);
			String[] order_details = order.split(" ");
			
			prices.add(Double.parseDouble(order_details[3]));
			
		}
		
		Double[] prices_array = new Double[prices.size()];
		prices_array = prices.toArray(prices_array);
		Arrays.sort(prices_array);
		
		return prices_array;
	}

	private static void matchOrder(HashMap<Integer, String> orders_map, HashMap<Integer, String> buy_orders,
			HashMap<Integer, String> sell_orders, String[] order_details, Integer[] cancelled_orders_array, Integer[] cancelled_orders_instance_array, Integer order_key) {
		
//		System.out.println("----------------------");

		for(Integer key : sell_orders.keySet()) {
			String order = orders_map.get(key);
		
			if(!order.equals("")) {
				String[] sell_order_details = order.split(" ");
				boolean crossover = false;
				for (int i = 0; i < cancelled_orders_array.length; i++) {
//					System.out.println(cancelled_orders_array[i]);
					if(cancelled_orders_array[i] == key || cancelled_orders_array[i] == order_key) {
						if(key < cancelled_orders_instance_array[i] && order_key < cancelled_orders_instance_array[i]) {
							continue;
						} else {
							crossover = true;
							break;
						}
					}
				}
				
				if(((sell_order_details[0].equals("limit") && (Double.parseDouble(sell_order_details[3]) <= Double.parseDouble(order_details[3]))) || (sell_order_details[0].equals("market")) || (sell_order_details[0].equals("stop") && (Double.parseDouble(sell_order_details[3]) >= Double.parseDouble(order_details[3])))) && (!crossover)) {
					
					int sell_order_number = key;
					int buy_order_number = order_key;
					int volume = Math.min(Integer.parseInt(order_details[2]), Integer.parseInt(sell_order_details[2]));
					double price = Double.parseDouble(order_details[3]);
					
					System.out.println("match " + sell_order_number + " " + buy_order_number + " " + volume + " " + price);
					
					if(Integer.parseInt(order_details[2]) == volume) {
						sell_order_details[2] = "" + (Integer.parseInt(sell_order_details[2]) - volume);
						orders_map.put(order_key, "");
						orders_map.put(key, (sell_order_details[0] + " " + sell_order_details[1] + " " + sell_order_details[2] + " " + sell_order_details[3]));
						sell_orders.put(key, (sell_order_details[0] + " " + sell_order_details[1] + " " + sell_order_details[2] + " " + sell_order_details[3]));
						break;
					} else {
						order_details[2] = "" + (Integer.parseInt(order_details[2]) - volume);
						orders_map.put(order_key, (order_details[0] + " " + order_details[1] + " " + order_details[2] + " " + order_details[3]));
						buy_orders.put(order_key, (order_details[0] + " " + order_details[1] + " " + order_details[2] + " " + order_details[3]));
						sell_orders.put(key, "");
					}
				}
			}
		}
	}

	private static void cancelledOrders(HashMap<Integer, String> orders_map, ArrayList<Integer> cancelled_orders_list, ArrayList<Integer> cancelled_orders_instance) {
		
		for(Integer key : orders_map.keySet()) {
			String order = orders_map.get(key);
			String[] order_details = order.split(" ");
			if(order_details[0].equals("cancel")) {
				cancelled_orders_list.add(Integer.parseInt(order_details[2]));
				cancelled_orders_instance.add(key);
			}
		}
	}
}
