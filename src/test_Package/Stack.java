package test_Package;

import java.io.IOException;

class StackTest {
	
	int top;
	int maxSize;
	int [] stackArray;
	
	public StackTest(int size) {
		// TODO Auto-generated constructor stub
		maxSize = size;
		stackArray = new int[size];
		top = -1;
	}
	
	public void push(int x) {
		
		if (top == (maxSize - 1))
			System.out.println("Array full.");
		else {
			top ++;
			stackArray[top] = x;
		}
	}
	
	public void pop() {
		
		if (top == -1)
			System.out.println("Array empty.");
		else
			top--;
	}
	
	public void display() {
		
		for (int i = 0; i <= top; i++) {
			System.out.println(stackArray[i]);
		}
	}
}

public class Stack {
	
	public static void main(String args[]) throws IOException {
		// TODO Auto-generated method stub
		StackTest t = new StackTest(100);
		t.push(100);
		t.pop();
		t.push(200);
		t.push(400);
		t.push(300);
		t.push(600);
		t.pop();
		t.push(300);
		t.pop();
		
		t.display();
		
	}
}