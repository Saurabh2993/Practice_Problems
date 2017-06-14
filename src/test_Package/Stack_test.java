package test_Package;

import java.io.IOException;

public class Stack_test {
	
	int stack_array[];
	int top;
	int count;
	int size;
	
	public void create(int new_size) {
		
		stack_array = new int[new_size];
		top = -1;
		size = new_size;
		count = 0;
		
	}

	public void push(int x) {
		
		if (top == (size - 1)) {
			increaseSize();
			top ++;
			count++;
			stack_array[top] = x;
		}
		else {
			top ++;
			count++;
			stack_array[top] = x;
		}
	}
	
	private void increaseSize() {
		// TODO Auto-generated method stub
		System.out.println("Increasing size of the stack");
		int temp[] = new int[size];
		for (int i = 0; i < size; i++) {
			temp[top] = stack_array[top];
			pop();
		}
		
		int old_size = size;
		create(size * 2);
		
		for (int i = 0; i < old_size; i++) {
			push(temp[i]);
			count++;
		}
	}

	public void pop() {
		
		if (top == -1)
			System.out.println("Stack empty.");
		else {
			top--;
			count--;
		}
			
	}
	
	public boolean isEmpty() {
		
		if(top == -1)
			return true;
		else
			return false;
			
	}
	
	public int count() {
		
		return count;
		
	}
	
	public void display() {
		
		for (int i = 0; i <= top; i++) {
			System.out.println(stack_array[i]);
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		// TODO Auto-generated method stub
		Stack_test t = new Stack_test();
		
		t.create(10);
		
		t.push(100);
		t.push(200);
		t.push(300);
		t.push(400);
		t.push(500);
		t.push(600);
		t.push(700);
		t.push(800);
		t.push(900);
		t.push(1000);
		t.push(1100);
		t.push(1200);
		
		t.display();
		
	}
	
}
