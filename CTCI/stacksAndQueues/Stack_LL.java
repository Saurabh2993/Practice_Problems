package stacksAndQueues;

import java.util.EmptyStackException;

public class Stack_LL<T> {
	
	private static class StackNode<T> {
		
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	
	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}
	
	public T pop() {
		if(top == null)
			throw new EmptyStackException();
		
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public T peek() {
		if(top == null)
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}

}
