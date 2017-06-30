package test_Package;

import java.util.EmptyStackException;

public class MultiStacks {
	
//	Stack info is used to maintain a metadata about the stacks that are created.
	private class StackInfo {
		public int start, size, capacity;
		
		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
		}
		
//		If an index is within the stack's capacity
		public boolean isWithinCapacity(int index) {
			if(index < 0 || index >= capacity) {
				return false;
			}
			
			int contiguousindex = index < start ? index + values.length : index;
			int end = start + capacity;
			
			return start <= contiguousindex && contiguousindex < end;
		}
		
//		Check if a stack is full
		public boolean isFull() {
			return size == capacity;
		}
		
//		Check if a stack is empty
		public boolean isEmpty() {
			return size == 0;
		}
		
//		Get last index of stack
		public int getLastIndex() {
			return adjustIndex(start + size - 1);
		}
		
//		Get last index within a stack's capacity
		public int lastCapacityIndex() {
			return adjustIndex(start + capacity - 1);
		}
	}
	
	private int values[];
	private StackInfo info[];
	
	public MultiStacks(int stackCount, int defaultSize) {
		
		info = new StackInfo[stackCount];
		for (int i = 0; i < stackCount; i++) {
			info[i] = new StackInfo(i * defaultSize, defaultSize);
		}
		
		values = new int[defaultSize * stackCount];
	}
	
//	Push an element in the stack of given number
	public void push(int stackNum, int data) throws FullStackException {
		if(allStacksFull()) {
			throw new FullStackException();
		}
		
		StackInfo curr = info[stackNum];
		if(curr.isFull()) {
			expand(stackNum);
		}
		
		curr.size++;
		values[curr.getLastIndex()] = data;
		
	}
	
//	Pop an element from the given stack
	public int pop(int stackNum) {
		StackInfo curr = info[stackNum];
		if(curr.isEmpty()) {
			throw new EmptyStackException();
		}
		
		int top_index = curr.getLastIndex();
		int value = values[top_index];
		values[top_index] = 0;
		curr.size--;
		return value;
	}
	
//	Peek at the top element of the given stack
	public int peek(int stackNum) {
		StackInfo curr = info[stackNum];
		if(curr.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return values[curr.getLastIndex()];
	}
	
	
//	Expand the given stack to accommodate a new element
	private void expand(int stackNum) {
		shift((stackNum + 1) % info.length);
		info[stackNum].capacity++;
	}
	
//	Shift the array one step ahead
	private void shift(int stackNum) {
		StackInfo curr = info[stackNum];
		
		if(curr.size >= curr.capacity) {
			shift((stackNum + 1) % info.length);
			curr.capacity++;
		}
		
		int index = curr.lastCapacityIndex();
		while(curr.isWithinCapacity(index)) {
			int prev_index = previousIndex(index);
			values[index] = values[prev_index];
			index = prev_index;
		}
		
		values[curr.start] = 0;
		curr.start = nextIndex(index);
		curr.capacity--;
	}
	
//	Adjust the given index to fit within the array limits
	private int adjustIndex(int index) {
		int max = values.length;
		return (((index % max) + max) % max);
	}
	
//	Get previous index
	private int previousIndex(int index) {
		return adjustIndex(index - 1);
	}
	
//	Get next index
	private int nextIndex(int index) {
		return adjustIndex(index + 1);
	}
	
//	Check if all the stacks are full
	public boolean allStacksFull() {
		return numberOfElements() == values.length;  
	}
	
//	Get the total number of elements in all stacks
	public int numberOfElements() {
		int total_size = 0;
		for (StackInfo curr : info) {
			total_size += curr.size;
		}
		
		return total_size;
	}

}
