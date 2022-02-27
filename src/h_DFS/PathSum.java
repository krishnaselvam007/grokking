package h_DFS;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		boolean result = findSum(root, 12);
		System.out.println(result);
	}

	private static boolean findSum(TreeNode root, int sum) {
		if (root == null ) return false;
		if (root.left == null && root.right == null && sum == root.val) return true;
		return findSum(root.left, sum - root.val) || findSum(root.right, sum - root.val);
	}

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}