package c_fast_slow;

/*
 * Problem 1: Given the head of a LinkedList with a cycle, find the length of
 * the cycle.
 */

public class LinkedListCycle2 {
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("LinkedList has cycle :: "+LinkedListCycle2.findCycleLength(head));
		
		head.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has cycle :: "+LinkedListCycle2.findCycleLength(head));
		
		head.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList has cycle :: "+LinkedListCycle2.findCycleLength(head));
	}

	private static int findCycleLength(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null ) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) return calculateLength(slow);
		}
		return 0;
	}

	private static int calculateLength(ListNode slow) {
		
		ListNode current = slow;
		int count = 0;
		do {
			
			current = current.next;
			count++;
			System.out.println(count);
			System.out.println("Slow value :: "+slow.value);
			System.out.println("Current value :: "+current.value);
			
		}while (current != slow); 
		
		return count;
	}

}
