package g_BFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	/*
	 * Problem Statement # Given a binary tree, populate an array to represent its
	 * level-by-level traversal. You should populate the values of all nodes of each
	 * level from left to right in separate sub-arrays.
	 */
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		List<List<Integer>> result = traverse(root);
		System.out.println(result);

	}

	private static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			System.out.println("size :: "+size);
			List<Integer> currentLevel = new ArrayList<Integer>(size);
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				currentLevel.add(node.val);
				System.out.println("Current Level :: "+currentLevel);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			result.add(currentLevel);
		}
		return result;
	}

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}
