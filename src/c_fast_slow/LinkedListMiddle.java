package c_fast_slow;

/*Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.*/

public class LinkedListMiddle {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		head.next.next.next.next = new ListNode(5);
		System.out.println("Cycle Middle node is :: "+ LinkedListMiddle.findCycleMiddle(head));
		
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("Cycle Middle node is :: "+ LinkedListMiddle.findCycleMiddle(head));
		
		head.next.next.next.next.next.next = new ListNode(7);
		System.out.println("Cycle Middle node is :: "+ LinkedListMiddle.findCycleMiddle(head));
	}

	public static int findCycleMiddle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.value;
	}
}
