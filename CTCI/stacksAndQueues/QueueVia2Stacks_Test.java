package stacksAndQueues;

public class QueueVia2Stacks_Test {
	
	public static void main(String args[]) {
		
		QueueViaStacks q = new QueueViaStacks();
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		
		System.out.println(q.remove());
		System.out.println(q.peek());
		
		
	}

}
