package test_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Linked_List {
	
	ListNode head = null;
	int count = 0;

	public static void main(String args[]) {
		
		Linked_List l1 = new Linked_List();
		l1.run();
		System.out.println(l1.isPalindrome(l1.head));
		
//		Linked_List l2 = new Linked_List();
//		l2.run2();
		
//		ListNode ans_head = addTwoNumbers(l1.head, l2.head);
		
//		while (ans_head != null) {
//			System.out.print(ans_head.value);
//			ans_head = ans_head.next;
//		}
			
	}

	public void run() {
		
		insert(7);
		insert(2);
		insert(4);
		insert(4);
		insert(2);
		insert(7);

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

	//Display total count of elements in the list
	public void displayCount() {
		
		System.out.println("Number of elements in list: " + count);
		
	}
	
	//Display all elements in the list
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
	
	//Check if the list is a palindrome(revesing a list approach)
/*	public boolean isPalindrome(ListNode head) {
		
		ListNode reverse = reverseList(head);
		
		return isEqual(head, reverse);
	}*/
	
	public boolean isPalindrome(ListNode head) {
		
		if(head.next == null) {
			return true;
		}
		
		ListNode slow = head;
		ListNode fast = head;

		Stack<Integer> nums = new Stack<>();
		
		while (fast != null && fast.next != null) {
			nums.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			if(slow.value != nums.pop()) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
	
	
	private boolean isEqual(ListNode head, ListNode reverse) {

		while(head != null) {
			if(head.value != reverse.value) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
			
		}
		
		return true;
	}

	//Reverse a list
	public ListNode reverseList(ListNode node) {
		
		ListNode head = null;
		
		while(node != null) {
			
			ListNode temp = new ListNode(node.value);
			temp.next = head;
			head = temp;
			
			node = node.next;
		}
		
		return head;
	}
	
	public ListNode isCyclic(ListNode node) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				break;
			}
		}
		
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
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
	
	//add two numbers  given as 6 -> 1 -> 7 + 2 -> 9 -> 5 = 9 -> 1 -> 2
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
	
	public ListNode rotateRight(ListNode head, int k) {
		
		int len = length(head);
		if(len <= 1) {
			return head;
		}
		
		k = k % len;
		
		ListNode slow = head;
		ListNode fast = head;
		
		int count = 0;
		
		while(fast.next != null) {
			fast = fast.next;
			if(count >= k) {
				slow = slow.next;
			}
			count++;
		}
		
		fast.next = head;
		head = slow.next;
		slow.next = null;
		
		return head;
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
