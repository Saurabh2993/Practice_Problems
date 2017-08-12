package leetcode_hard;

import java.util.HashMap;

public class LRU_Cache {
	
	int maxSize;
	HashMap<Integer, DoublyLinkedListNode> kv_map = new HashMap<>();
	DoublyLinkedListNode listHead;
	DoublyLinkedListNode listTail;
	
	public LRU_Cache(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void put(int key, int value) {
		
		if(kv_map.containsKey(key)) {
			DoublyLinkedListNode old = kv_map.get(key);
			old.value = value;
			removeFromList(old);
			insertNodeAtFront(old);
		} else {
			DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
			if(kv_map.size() >= maxSize) {
				kv_map.remove(listTail.key);
				removeFromList(listTail);
				insertNodeAtFront(node);
			} else {
				insertNodeAtFront(node);
			}
			kv_map.put(key, node);
		}
	}
	
	public int get(int key) {
		if(kv_map.containsKey(key)) {
			DoublyLinkedListNode node = kv_map.get(key);
			removeFromList(node);
			insertNodeAtFront(node);
			return node.value;
		}
		
		return -1;
	}
	
	private void insertNodeAtFront(DoublyLinkedListNode node) {
		node.next = listHead;
		node.prev = null;
		
		if(listHead != null) {
			listHead.prev = node;
		}
		
		listHead = node;
		
		if(listTail == null) {
			listTail = listHead;
		}
	}
	
	private void removeFromList(DoublyLinkedListNode node) {
		if(node == null) {
			return;
		}
		
		if(node.prev != null) {
			node.prev.next = node.next;
		} else {
			listHead = node.next;
		}
		
		if(node.next != null) {
			node.next.prev = node.prev;
		} else {
			listTail = node.prev;
		}
	}

}

class DoublyLinkedListNode {
	
	int key;
	int value;
	DoublyLinkedListNode next, prev;
	
	public DoublyLinkedListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
