package test_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Linked_List {
	
	ListNode head = null;
	int count = 0;

	public static void main(String args[]) {
		
		Linked_List l1 = new Linked_List();
		l1.run();
		
//		Linked_List l2 = new Linked_List();
//		l2.run2();
		
//		addTwoNumbers(l1.head, l2.head);
			
	}

	private static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		
		if(head1 == null) {
			return head2;
		} else if(head2 == null) {
			return head1;
		}
		
		Linked_List result = new Linked_List();
		result.insert(0);
		
		ListNode ans_node = result.head;
		ListNode node1 = head1;
		ListNode node2 = head2;
		
		
		while (node1 != null && node2 != null) {
			
			System.out.println(node1.value + "  " + node2.value + "  " + ans_node.value);
			
			int temp = ans_node.value + node1.value + node2.value;
			
			if(temp >= 10) {
				ans_node.value = temp % 10;
				result.insert(temp / 10);
			} else {
				ans_node.value = temp;
				if(node1.next != null || node2.next != null)
					result.insert(0);
			}
			
//			System.out.println(ans_node.value);
			node1 = node1.next;
			node2 = node2.next;
			ans_node = ans_node.next;
		}
		
		ListNode rem = null;
		if(node1 != null) {
			rem = node1;
		}else if(node2 != null) {
			rem = node2;
		}
		
		while(rem != null) {
//			System.out.println("Remaining");
			int temp = ans_node.value + rem.value;
			if(temp >= 10) {
				ans_node.value = temp % 10;
				result.insert(temp / 10);
			} else {
				ans_node.value = temp;
				if(rem.next != null)
					result.insert(0);
			}
			rem = rem.next;
			ans_node = ans_node.next;
		}

		result.displayAll();
		
		return result.head;
		
	}

	public void run() {
		
		insert(9);
		insert(1);
		insert(6);
		insert(3);
		displayAll();
		delete(9);
		displayAll();
		
	}
	
	private void run2() {
		
		insert(0);
//		insert(6);
//		insert(4);
		
	}

	public void displayCount() {
		
		System.out.println("Number of elements in list: " + count);
		
	}

	public void displayAll() {
		
		if(head == null) {
			System.out.println("Empty List");
		} else if(head.next == null) {
			System.out.println(head.value);
		} else {
		
			ListNode node = head;
			while (node.next != null) {
				System.out.println(node.value);
				node = node.next;
			}
			System.out.println(node.value);
		}
	}

	public void insert(int i) {
		
		if(head == null) {
			System.out.println("Adding first element");
			addFirst(i);
		}	
		else if(head.next == null) {
			head.next = new ListNode(i);
			head.next.next = null;
		}
		else {
			ListNode node = head;
			while (node.next != null) {
				node = node.next;
			} 
			node.next = new ListNode(i);
		}
		count ++;
	}
	
	private void delete(int i) {
		
		if(head == null)
			System.out.println("Empty List");
		
		else {
			ListNode node = head;
			if (node.value == i) {
				head = head.next;
				System.out.println("Deleted value: " + i);
			} else {
				while(node.next != null) {
					if(node.next.value == i) {
						node.next = node.next.next;
						System.out.println("Deleted value: " + i);
						break;
					}
					node = node.next;
				}
			}
		}
		
		
	}

	public void addFirst(int i) {
		
		head = new ListNode(i);
		head.next = null;
		
	}
	
}
