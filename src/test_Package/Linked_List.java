package test_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Linked_List {
	
	ListNode head = null;
	int count = 0;

	public static void main(String args[]) {
		
		Linked_List l1 = new Linked_List();
		l1.run();
		
		Linked_List l2 = new Linked_List();
		l2.run2();
		
		ListNode ans_head = addTwoNumbers(l1.head, l2.head);
		
		while (ans_head != null) {
			System.out.print(ans_head.value);
			ans_head = ans_head.next;
		}
			
	}

	public void run() {
		
		insert(7);
		insert(2);
		insert(4);
		insert(3);

//		displayAll();
//		kthLastElement(head, 6);
//		removeDuplicates(head);
//		delete(3);
		
	}
	
	private void run2() {
		
		insert(5);
		insert(6);
		insert(4);
		
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
	
/*	private static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		
		if(head1 == null) {
			return head2;
		} else if(head2 == null) {
			return head1;
		}
		
		ListNode ans_node = new ListNode(0);
		ListNode ans_head = ans_node;
		ListNode node1 = head1;
		ListNode node2 = head2;
		ListNode x;
// 		System.out.println(ans_node.val);
		
		while (node1 != null && node2 != null) {
			
// 			System.out.println(ans_node.val);
			
			int temp = ans_node.value + node1.value + node2.value;
			
			if(temp >= 10) {
				ans_node.value = temp % 10;
				x = new ListNode(temp / 10);
				ans_node.next = x;
			} else {
				ans_node.value = temp;
				if(node1.next != null || node2.next != null) {
					x = new ListNode(0);
					ans_node.next = x;
				}
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

			int temp = ans_node.value + rem.value;
			if(temp >= 10) {
				ans_node.value = temp % 10;
				x = new ListNode(temp / 10);
				ans_node.next = x;
			} else {
				ans_node.value = temp;
				if(rem.next != null) {
					x = new ListNode(0);
					ans_node.next = x;
				}
			}
			rem = rem.next;
			ans_node = ans_node.next;
		}

		return ans_head;
		
	}*/
	
	private static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		
		int list1_len = length(head1);
		int list2_len = length(head2);
		
		ListNode node1 = head1;
		ListNode node2 = head2;
		
		if(list1_len < list2_len) {
			node1 = padList(head1, list2_len - list1_len);
		} else {
			node2 = padList(head2, list1_len - list2_len);
		}
		
		PartialSum sum = addListHelper(node1, node2);
		
		if(sum.carry == 0) {
			return sum.sum;
		} else {
			ListNode answer = insertBefore(sum.sum, sum.carry);
			return answer;
		}
	}
	
	static PartialSum addListHelper(ListNode node1, ListNode node2) {
		
		if(node1 == null && node2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		
		PartialSum sum = addListHelper(node1.next, node2.next);
		
		int val = node1.value + node2.value + sum.carry;
		
		ListNode result = insertBefore(sum.sum, val % 10);
		sum.sum = result;
		sum.carry = val / 10;
		
		return sum;
		
	}
	
	public static ListNode insertBefore(ListNode node, int value) {
		
		ListNode temp = new ListNode(value);
		temp.next = node;
		
		return temp;
	}
	
	public static int length(ListNode node) {
		
		int len = 0;
		while (node != null) {
			len ++;
			node = node.next;
		}
		
		return len;
	}
	
	public void kthLastElement(ListNode head, int k) {
		
		if(head == null) {
			System.out.println("Empty List");
		} else {
			int count = 1;
			ListNode node1 = head;
			ListNode node2 = head;
			while(node1.next != null) {
				if(count >= k) {
					node2 = node2.next;
				}
				node1 = node1.next;
				count++;
			}
			System.out.println(node2.value);
			
			
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
	
	public static ListNode padList(ListNode node, int len) {
		
		for (int i = 0; i < len; i++) {
			ListNode temp = new ListNode(0);
			temp.next = node;
			node = temp;
		}
		
		return node;
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
	
	/*O(n) solution using Hashset
	public void removeDuplicates(ListNode head) {
		
		if(head == null)
			System.out.println("Empty List");
		else {
			
			HashSet<Integer> unique_values = new HashSet<>();
			ListNode node = head;
			unique_values.add(node.value);
			while(node.next != null) {
				System.out.println(node.next.value);
				if(unique_values.contains(node.next.value)) {
					System.out.println("Deleted value: " + node.next.value);
					node.next = node.next.next;
				} else {
					unique_values.add(node.next.value);
					node = node.next;
				}
			}
		}
	}*/
	
//	O(n^2) solution without extra space
	public void removeDuplicates(ListNode head) {
		
		if(head == null)
			System.out.println("Empty List");
		
		else {
			ListNode node1 = head;
			ListNode node2;
			
			if(node1.next != null) {
				while(node1.next != null) {
					node2 = node1;
					int x = node1.value;
			
					while(node2.next != null) {
						if(node2.next.value == x) {
							System.out.println("Deleted value: " + node2.next.value);
							node2.next = node2.next.next;
						} else {
							node2 = node2.next;
						}
					}
					node1 = node1.next;
				}
			}
		}
	}

	public void addFirst(int i) {
		
		head = new ListNode(i);
		head.next = null;
		
	}
	
}

class PartialSum {
	public ListNode sum = null;
	int carry = 0;
}
