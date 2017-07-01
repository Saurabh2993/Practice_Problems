package stacksAndQueues;

public class QueueViaStacks extends Stack_LL<Integer> {
	
	Stack_LL<Integer> head_stack;
	Stack_LL<Integer> tail_stack;
	int size;
	
	public QueueViaStacks() {
		head_stack = new Stack_LL<>();
		tail_stack = new Stack_LL<>();
		size = 0;
	}
	
	public void add(int x) {
		tail_stack.push(x);
	}
	
	public Integer remove() {
		shiftStacks();
		return head_stack.pop();
	}
	
	public Integer peek() {
		shiftStacks();
		return head_stack.peek();
	}
	
	private void shiftStacks() {
		if(head_stack.isEmpty()) {
			while(!tail_stack.isEmpty()) {
				head_stack.push(tail_stack.pop());
			}
		}
	}
}
