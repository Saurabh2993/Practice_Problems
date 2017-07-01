package stacksAndQueues;

import java.util.ArrayList;

public class Set_Of_Stacks extends Stack_LL<Integer> {
	
	ArrayList<Stack_LL<Integer>> stacks;
	int max_cap = 10;
	
	public Set_Of_Stacks() {
		stacks = new ArrayList<>();
		Stack_LL<Integer> temp = new Stack_LL<>();
		stacks.add(temp);
	}
	
	public void push(int x) {
		Stack_LL<Integer> last_stack = getLastStack();
		System.out.println(last_stack.getSize());
		
		if(last_stack.getSize() == max_cap) {
			System.out.println("Creating new Stack");
			last_stack = addStack();
		}
		
		last_stack.push(x);
	}
	
	public Integer pop() {
		Stack_LL<Integer> last_stack = getLastStack();
		Integer data = last_stack.pop();
		
		if(last_stack.getSize() == 0) {
			removeLastStack();
		}
		
		return data;
	}
	
	public Integer peek() {
		Stack_LL<Integer> last_stack = getLastStack();
		return last_stack.peek();
	}
	
	public Stack_LL<Integer> addStack() {
		Stack_LL<Integer> new_stack = new Stack_LL<>();
		stacks.add(new_stack);
		return new_stack;
	}
	
	public void removeLastStack() {
		stacks.remove(stacks.size() - 1);
	}
	
	public Stack_LL<Integer> getLastStack() {
		return(stacks.get(stacks.size() - 1));
	}
	
	public int getTotalSize() {
		int total_size = 0;
		for(Stack_LL<Integer> temp : stacks) {
			total_size += temp.getSize();
		}
		
		return total_size;
	}

}
