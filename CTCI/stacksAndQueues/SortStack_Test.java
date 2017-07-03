package stacksAndQueues;

import java.util.ArrayList;

public class SortStack_Test {
	
	public static void main(String args[]) {
		
		SortStack ss = new SortStack();
		
		ss.push(5);
		ss.push(2);
		System.out.println(ss.peek());
		ss.push(6);
		System.out.println(ss.peek());
		ss.push(14);
		System.out.println(ss.peek());
		ss.push(1);
		System.out.println(ss.peek());
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
		System.out.println(Math.sqrt(5));
		
	}
	

}
