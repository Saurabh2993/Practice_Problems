package stacksAndQueues;

import java.util.ArrayList;

public class Set_Of_Stacks2 extends Stack_LL<Integer> {
	
	ArrayList<Stack_LL2<Integer>> stacks;
	int max_cap = 10;
	
	public Set_Of_Stacks2() {
		stacks = new ArrayList<>();
		Stack_LL2<Integer> temp = new Stack_LL2<>();
		stacks.add(temp);
	}
	
	public void push(int x) {
		Stack_LL2<Integer> last_stack = getLastStack();
		System.out.println(last_stack.getSize());
		
		if(last_stack.getSize() == max_cap) {
			System.out.println("Creating new Stack");
			last_stack = addStack();
		}
		
		last_stack.push(x);
	}
	
	public Integer pop() {
		Stack_LL2<Integer> last_stack = getLastStack();
		Integer data = last_stack.pop();
		
		if(last_stack.getSize() == 0) {
			removeLastStack();
		}
		
		return data;
	}
	
	public Integer popAtIndex(int index) {
		return leftShift(index, true);
	}
	
	public Integer leftShift(int index, boolean removeTop) {
		Stack_LL2<Integer> stack = getStackAtIndex(index);
		Integer data = null;
		if(removeTop) {
			data = stack.pop();
		} else {
			stack.removeBottom();
		}
		if(stack.isEmpty()) {
			removeStackAtIndex(index);
		} else if(stacks.size() > index + 1) {
			Integer x = leftShift(index + 1, false);
			stack.push(x);
		}
		
		return data;
	}
	
	public Integer peek() {
		Stack_LL2<Integer> last_stack = getLastStack();
		return last_stack.peek();
	}
	
	public Stack_LL2<Integer> addStack() {
		Stack_LL2<Integer> new_stack = new Stack_LL2<>();
		stacks.add(new_stack);
		return new_stack;
	}
	
	public void removeLastStack() {
		stacks.remove(stacks.size() - 1);
	}
	
	public void removeStackAtIndex(int index) {
		stacks.remove(index);
	}
	
	public Stack_LL2<Integer> getLastStack() {
		return(stacks.get(stacks.size() - 1));
	}
	
	private Stack_LL2<Integer> getStackAtIndex(int index) {
		return(stacks.get(index));
	}
	
	public int getTotalSize() {
		int total_size = 0;
		for(Stack_LL2<Integer> temp : stacks) {
			total_size += temp.getSize();
		}
		
		return total_size;
	}

}