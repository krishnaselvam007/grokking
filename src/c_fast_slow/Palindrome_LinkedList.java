package c_fast_slow;

/*Palindrome LinkedList (medium) #
Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

Example 1:

Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true*/

public class Palindrome_LinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);
		System.out.println("Cycle Middle node is :: "+ Palindrome_LinkedList.isPalindrome(head));
		
		//head.next.next.next.next.next = new ListNode(6);
		//System.out.println("Cycle Middle node is :: "+ Palindrome_LinkedList.isPalindrome(head));
		
		head.next.next.next.next.next.next = new ListNode(7);
		System.out.println("Cycle Middle node is :: "+ Palindrome_LinkedList.isPalindrome(head));		
	}

	private static Boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode actSecHalf = reverse(slow);
		ListNode cpActSecHalf = actSecHalf;
		
		while(head != null && actSecHalf != null) {
			if(head.value != actSecHalf.value) {
				break;
			}
			head = head.next;
			actSecHalf = actSecHalf.next;
		}
		reverse(cpActSecHalf);
		if (head == null || actSecHalf == null) {
			return true;
		}		
		return false;
	}

	private static ListNode reverse(ListNode slow) {
		ListNode prev = null;
		while (slow != null) {
			ListNode nxt = slow.next;
			slow.next = prev;
			prev = slow;
			slow = nxt;
			System.out.println(prev.value);
		}
		return prev;
	}

}
