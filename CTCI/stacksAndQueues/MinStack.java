package stacksAndQueues;

public class MinStack extends Stack_LL<Integer> {
	
	Stack_LL<Integer> s2;
	
	public MinStack() {
		s2 = new Stack_LL<Integer>();
	}
	
	public void push(int value) {
		super.push(value);
		if(value < min()) {
			s2.push(value);
		}
	}
	
	public Integer pop() {
		int popped_value = super.pop();
		if(popped_value == min()) {
			s2.pop();
		}
			
		return popped_value;
	}
	
	public int min() {
		if(s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}

}
