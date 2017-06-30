package stacksAndQueues;

public class MinStack_Test {
	
	public static void main(String args[]) {
		
		MinStack ms = new MinStack();
		ms.push(10);
		ms.push(20);
		ms.push(30);
		System.out.println(ms.min());
		ms.push(8);
		ms.push(40);
		System.out.println(ms.min());
		ms.pop();
		System.out.println(ms.min());
		ms.pop();
		System.out.println(ms.min());
		
	}

}
