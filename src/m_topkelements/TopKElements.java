package m_topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {

	public static void main(String[] args) {
		System.out.println(findklargestnumbers(new int[] {2,1,3,24,12,5,9}, 3));
	}

	private static List<Integer> findklargestnumbers(int[] is, int i) {
		PriorityQueue<Integer> minheap = new PriorityQueue<>((n1,n2) -> n1-n2);
		for (int j = 0; j < i; j++) {
			minheap.add(is[j]);
		}
		
		for (int j = 0; j < is.length; j++) {
			if(is[j] > minheap.peek()) {
				minheap.poll();
				minheap.add(is[j]);
			}
		}
		return new ArrayList<>(minheap);
	}

}
