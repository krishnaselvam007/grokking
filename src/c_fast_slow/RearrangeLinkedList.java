package c_fast_slow;

/*Rearrange a LinkedList (medium) #
Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.

Your algorithm should not use any extra space and the input LinkedList should be modified in-place.*/

public class RearrangeLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);
		rearrange(head);
		while(head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public static void rearrange(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode actSecHalf = reverse(slow);
		ListNode headFirstHalf = head;
		
		while (headFirstHalf != null && actSecHalf != null) {
			ListNode temp = headFirstHalf.next;
			headFirstHalf.next = actSecHalf;
			headFirstHalf = temp;
			temp = actSecHalf.next;
			actSecHalf.next = headFirstHalf;
			actSecHalf = temp;
		}
		if (headFirstHalf != null) {
			headFirstHalf.next = null;
		}
	}

	private static ListNode reverse(ListNode slow) {
		ListNode prev = null;
		while (slow != null) {
			ListNode nxt = slow.next;
			slow.next = prev;
			prev = slow;
			slow = nxt;
		}
		return prev;
	}

}
