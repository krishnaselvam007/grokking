package c_fast_slow;

import java.util.stream.IntStream;

public class Happy_Number_03 {

	public static void main(String[] args) {
		int a = 1, b = 100;
		long start = System.nanoTime();
		//int result = IntStream.rangeClosed(a, b).filter(Happy_Number_03::find).reduce(0, Integer::sum);
		int result = 0;
		for (int i = a; i <= b; i++) {
			if(find(i)) {
				System.out.println(i);
				result += i;
			}
		}
		long end = System.nanoTime();
		System.out.println(result);
		System.out.println(end - start);
	}
	
	public static boolean find(int x) {
		
		int slow = x, fast = x;
		do {
			slow = findSquare(slow);
			fast = findSquare(findSquare(fast));
		}while(slow!=fast);
		
		return slow == 1;
	}

	private static int findSquare(int slow) {
		int sum = 0, digit;
		while (slow > 0) {
			digit = slow % 10;
			sum += digit * digit;
			slow /= 10;
		}
		
		return sum;
	}
}
