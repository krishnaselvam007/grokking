package a_windowSliding;

import java.util.HashMap;

/*Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']*/

public class e_FruitsBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxNoFruits(new char[] {'A', 'B', 'C', 'B', 'C', 'C'}));
	}

	private static int maxNoFruits(char[] cs) {
		int maxNum = 0, start = 0;
		HashMap<Character, Integer> fruits = new HashMap<>();
		for (int i = 0; i < cs.length; i++) {
			char a = cs[i];
			fruits.put(a, fruits.getOrDefault(a, 0)+1);
			while (fruits.size() > 2) {
				char b = cs[start];
				fruits.put(b, fruits.get(b)-1);
				if(fruits.get(b) == 0) fruits.remove(b);
				start ++;
			}
			//System.out.println("Max Length :: "+maxNum);
			//System.out.println(fruits);
			maxNum = Math.max(maxNum, i - start +1);
		}
		//System.out.println(fruits.values());
		return maxNum;
	}

}
