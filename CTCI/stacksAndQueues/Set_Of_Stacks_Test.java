package stacksAndQueues;

public class Set_Of_Stacks_Test {
	
	public static void main(String args[]) {
		
		Set_Of_Stacks2 ss = new Set_Of_Stacks2();
		
		ss.push(10);
		ss.push(20);
		ss.push(30);
		ss.push(40);
		ss.push(50);
		ss.push(60);
		ss.push(70);
		ss.push(80);
		ss.push(90);
		ss.push(100);
		ss.pop();
		ss.push(11);
		ss.push(01);
		ss.push(21);
		ss.push(31);
		ss.push(41);
		ss.push(51);
		ss.push(61);
		ss.push(71);
		ss.push(81);
		ss.push(91);
		System.out.println(ss.getTotalSize());
		
		
	}

}
