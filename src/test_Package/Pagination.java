package test_Package;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

public class Pagination {
	
	class Listing {
		int host_id;
		int listing_id;
		double score;
		String city;
		
		Listing(int host_id, int listing_id, double score, String city) {
			this.host_id = host_id;
			this.listing_id = listing_id;
			this.score = score;
			this.city = city;
		}
	}
	
	class ScoreComparator implements Comparator<Listing>  {
		@Override
		public int compare(Listing l1, Listing l2) {
			if(l1.score == l2.score) {
				return 0;
			}
			if(l1.score < l2.score) {
				return 1;
			}
			return -1;
		}
	}
	
	public void paginate(String[] results, int results_per_page) {
		
		List<Listing> results_list = new ArrayList<>();
		for(int i = 0; i < results.length; i ++) {
			String split_str[] = results[i].split(",");
			Listing l = new Listing(Integer.parseInt(split_str[0]), Integer.parseInt(split_str[1]), Double.parseDouble(split_str[2]), split_str[3]);
			results_list.add(l);
		}
		results_list.sort(new ScoreComparator());
		
		HashMap<Integer, Queue<Listing>> host_map = new HashMap<Integer, Queue<Listing>>();
		for(Listing i : results_list) {
			if(host_map.containsKey(i.host_id)) {
				host_map.get(i.host_id).add(i);
			} else {
				Queue<Listing> host_queue = new LinkedList<>();
				host_queue.add(i);
				host_map.put(i.host_id, host_queue);
			}
		}
		
		int page = 1;
		int total_pages = (int) Math.ceil(results_list.size() / (double) results_per_page);
		int total_results = results.length;
		int results_printed = 0;
		
		while(page <= total_pages) {
		
			System.out.println("Page: " + page);
			List<Integer> current_page_host_ids = new ArrayList<>();
			boolean reached_end_of_list = false;
			int result_count = 0;
			
			while(result_count != results_per_page) {
				
				if(results_printed == total_results) {
					break;
				}
				
				Map<Integer, Queue<Listing>> sorted_host_map = sortMapByComparator(host_map, false);
				for(Entry<Integer, Queue<Listing>> entry : sorted_host_map.entrySet()) {
//					System.out.println(entry.getKey());
					if(!current_page_host_ids.contains(entry.getKey()) || reached_end_of_list) {
						Listing current = entry.getValue().poll();
						
						if(current != null) {
							System.out.println(current.host_id + "  " + current.listing_id + "  " + current.score + "  " + current.city);
							result_count++;
							results_printed++;
							if(result_count == results_per_page || results_printed == total_results) {
								break;
							}
						} else {
							continue;
						}
					}
				}
				reached_end_of_list = true;
				
				host_map = new LinkedHashMap<>(sorted_host_map);
				for(Entry<Integer, Queue<Listing>> entry : sorted_host_map.entrySet()) {
					if(entry.getValue().size() == 0) {
						host_map.remove(entry.getKey());
					}
				}
			}
			page++;
		}
		
		
		
	}
	
	private Map<Integer, Queue<Listing>> sortMapByComparator(HashMap<Integer, Queue<Listing>> unsorted_map, final boolean order) {
		
		List<Entry<Integer, Queue<Listing>>> list = new LinkedList<Entry<Integer, Queue<Listing>>>(unsorted_map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Integer, Queue<Listing>>>() {

			@Override
			public int compare(Entry<Integer, Queue<Listing>> o1, Entry<Integer, Queue<Listing>> o2) {
				Double score1 = o1.getValue().peek().score;
				Double score2 = o2.getValue().peek().score;
				if(order) {
					return score1.compareTo(score2);
				} else {
					return score2.compareTo(score1);
				}
			}
		});
		
		Map<Integer, Queue<Listing>> sorted_map = new LinkedHashMap<Integer, Queue<Listing>>();
		for(Entry<Integer, Queue<Listing>> entry : list) {
			sorted_map.put(entry.getKey(), entry.getValue());
		}
		
		/*for(Entry<Integer, Queue<Listing>> entry : sorted_map.entrySet()) {
			System.out.println(entry.getKey());
		}*/
		
		return sorted_map;
	}

	public static void main(String args[]) {
		
		String results[] = {"1,28,100.3,Paris",
				  "4,5,99.2,Paris",
				  "2,7,90.5,Paris",
				  "8,8,87.6,Paris",
				  "6,10,85.6,Paris",
				  "3,16,82.16,Paris",
				  "7,29,81.1,Paris",
				  "9,20,78.9,Paris",
				  "12,21,74.3,Paris"};
		
		Pagination p = new Pagination();
		p.paginate(results, 3);
		
	}
	
	

}
