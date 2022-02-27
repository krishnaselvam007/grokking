package d_mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Interval {
	int start;
	int end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

/*
 * Problem Statement # Given a list of intervals, merge all the overlapping
 * intervals to produce a list that has only mutually exclusive intervals.
 */
public class MergeIntervals {

	public static void main(String[] args) {
		List<Interval> input = new ArrayList();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		System.out.println("Merged Intervals :: ");
		for (Interval interval: merge(input)) {
			System.out.print("["+interval.start+", "+interval.end+"]");
			System.out.println();
		}
		
		input = new ArrayList();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		System.out.println("Merged Intervals :: ");
		for (Interval interval: merge(input)) {
			System.out.print("["+interval.start+", "+interval.end+"]");
			System.out.println();
		}

	}

	private static List<Interval> merge(List<Interval> input) {
		List<Interval> mergedIntervals = new LinkedList<>();
		if(input.size() < 2) return input;
		Collections.sort(input, (a, b) -> Integer.compare(a.start, b.start));
		
		Iterator<Interval> intervalItr = input.iterator();
		Interval interval = intervalItr.next();
		int start = interval.start;
		int end = interval.end;
		
		while (intervalItr.hasNext()) {
			interval = intervalItr.next();
			if (interval.start <= end) {
				end = Math.max(interval.end, end);
			} else {
				mergedIntervals.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}			
		}
		mergedIntervals.add(new Interval(start, end));
		
		return mergedIntervals;
	}

}
