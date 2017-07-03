package stacksAndQueues;

public class SortStack extends Stack_LL<Integer>{
	
	Stack_LL<Integer> stack1;
	Stack_LL<Integer> stack2;
	
	public SortStack() {
		stack1 = new Stack_LL<>();
		stack2 = new Stack_LL<>();
	}
	
	public void push(int x) {
		if(stack1.isEmpty()) {
			stack1.push(x);
			return;
		}
		if(x <= stack1.peek()) {
			stack1.push(x);
		} else {
			pushToPosition(x);
		}
	}
	
	public Integer pop() {
		return stack1.pop();
	}
	
	private void pushToPosition(int x) {
		
		while(!stack1.isEmpty()) {
			if(x > stack1.peek()) {
				stack2.push(stack1.pop());
			} else {
				break; 
			}
		}
		stack1.push(x);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
	public Integer peek() {
		return stack1.peek();
	}
	
	public int getSize() {
		return stack1.getSize();
	}

}
