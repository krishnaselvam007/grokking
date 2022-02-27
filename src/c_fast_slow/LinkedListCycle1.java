package c_fast_slow;

class ListNode{
	int value = 0;
	ListNode next;
	
	ListNode(int value){
		this.value = value;
	}
}

/*
 * Problem Statement # 
 * Given the head of a Singly LinkedList, write a function
 * to determine if the LinkedList has a cycle in it or not.
 */

public class LinkedListCycle1 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("LinkedList has cycle :: "+LinkedListCycle1.hasCycle(head));
		
		head.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has cycle :: "+LinkedListCycle1.hasCycle(head));
		
		head.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList has cycle :: "+LinkedListCycle1.hasCycle(head));
		
	}

	private static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			System.out.println("Fast :: "+fast + " Slow :: "+slow);
			if (slow == fast) return true;
		}
		return false;
	}

}
