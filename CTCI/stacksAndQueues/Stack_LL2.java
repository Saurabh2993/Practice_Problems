package stacksAndQueues;

import java.util.EmptyStackException;

public class Stack_LL2<T> {
	
	private static class StackNode<T> {
		
		private T data;
		private StackNode<T> below, above;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> top, bottom;
	private int size = 0;
	
	public void join(StackNode above, StackNode below) {
		if(below != null) {
			below.above = above;
		}
		if(above != null) {
			above.below = below;
		}
	}
	
	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.below = top;
		top = t;
		size++;
		
		if(size == 1) {
			bottom = top;
		}
		join(t, top);
		
	}
	
	public T pop() {
		if(top == null)
			throw new EmptyStackException();
		
		T data = top.data;
		size--;
		top = top.below;
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
	
	public int getSize() {
		return size;
	}

	public T removeBottom() {
		StackNode b = bottom;
		bottom = bottom.above;
		if(bottom != null) {
			bottom.below = null;
		}
		size--;
		return (T) b.data;
	}

}
