package leetcode_hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	
	class MaxHeapComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer lhs, Integer rhs) {
			if(lhs == rhs) return 0;
			if(lhs < rhs) return 1;
			return -1;
		}
	}
	
	PriorityQueue<Integer> left_heap;
	PriorityQueue<Integer> right_heap;

	public MedianFinder() {
		right_heap = new PriorityQueue<>();
		left_heap = new PriorityQueue<>(new MaxHeapComparator());
	}
	
	public void addNum(int data) {
		if(left_heap.size() == right_heap.size()) {
			left_heap.add(data);
		} else {
			right_heap.add(data);
		}
		if(right_heap.size() != 0) {
			if(left_heap.peek() > right_heap.peek()) {
				int temp = left_heap.poll();
				left_heap.add(right_heap.poll());
				right_heap.add(temp);
			}
		}
	}
	
	public double findMedian() {
		if(left_heap.size() == right_heap.size()) {
			return (left_heap.peek() + right_heap.peek()) / 2.0;
		} else {
			return left_heap.peek() / 1.0;
		}
	}
	
	
	
	/*public Integer max_peek() {
		return max_heap.peek();
	}*/
	
	public static void main(String args[]) {
		
		MedianFinder mf = new MedianFinder();
		
		mf.addNum(3);
		mf.addNum(2);
		mf.addNum(7);
		mf.addNum(4);
		mf.addNum(1);
		mf.addNum(6);
		mf.addNum(5);
		mf.addNum(8);
		
		
		
	}
}
