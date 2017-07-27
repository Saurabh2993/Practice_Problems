package dynamicProgramming;

import java.util.Stack;

class Tower {
	
	Stack<Integer> tower = new Stack<>();
	public Tower() {
		tower = new Stack<>();
	}
	
	public void add(int i) {
		if(!tower.isEmpty() && tower.peek() <= i) {
			System.out.println("Error");
		} else {
			tower.push(i);
		}
	}
	
	public void moveDisks(int n, Tower dest, Tower buff) {
		if(n > 0) {
			moveDisks(n - 1, buff, dest);
			moveTopTo(dest);
			buff.moveDisks(n - 1, dest, this);
		}
	}

	private void moveTopTo(Tower dest) {
		int top = tower.pop();
//		System.out.println(top);
		dest.add(top);
	}
	
	
}

public class Tower_of_Hanoi {
	
	public static void main(String args[]) {
		
		int n = 3;
		Tower t[] = new Tower[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Tower();
		}
		
		for(int i = n; i > 0; i --) {
			t[0].add(i);
		}
		
		
		t[0].moveDisks(n, t[2], t[1]);
		while(t[2].tower.size() != 0) {
			System.out.println(t[2].tower.pop());
		}
	}

}
