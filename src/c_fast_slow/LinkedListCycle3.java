package c_fast_slow;

public class LinkedListCycle3 {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		head.next.next.next.next.next = head.next.next;
		System.out.println("value :: "+head.next.next.value);
		System.out.println("Cycle starts at :: "+ LinkedListCycle3.findCycleStart(head));
		
		head.next.next.next.next.next = head.next.next.next;
		System.out.println("value :: "+head.next.next.next.value);
		System.out.println("Cycle starts at :: "+ LinkedListCycle3.findCycleStart(head));
		
		head.next.next.next.next.next = head;
		System.out.println("value :: "+head.value);
		System.out.println("Cycle starts at :: "+ LinkedListCycle3.findCycleStart(head));
	}
	
	public static int findCycleStart(ListNode head) {
		int cycleLength = 0;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				cycleLength = calculateLength(slow);
				break;
			}
		}
		return findStart(head, cycleLength);
	}
	
	private static int findStart(ListNode head, int cycleLength) {
		ListNode p1 = head, p2 = head;
		while (cycleLength > 0) {
			p2 = p2.next;
			cycleLength--;
		}
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1.value;
	}

	public static int calculateLength(ListNode head) {
		ListNode current = head;
		int cycleLength = 0;
		do {
			current = current.next;
			cycleLength++;
		} while (current != head);		
		return cycleLength;
	}
}
