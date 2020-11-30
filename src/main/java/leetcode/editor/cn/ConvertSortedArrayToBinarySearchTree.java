//108
//
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 625 👎 0


package leetcode.editor.cn;

public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
		int[] nums = new int[]{-10, -3, 0, 5, 9};
		solution.sortedArrayToBST(nums);
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {

		public TreeNode sortedArrayToBST(int[] nums) {
			if (nums.length == 0) {
				return null;
			}

			return dfs(nums, 0, nums.length-1);
		}

		private TreeNode dfs(int[] nums, int left, int right) {
			if (left > right) {
				return null;
			}
			int mid = (left + right) / 2;
			TreeNode treeNode = new TreeNode(nums[mid]);
			treeNode.left = dfs(nums, left, mid-1);
			treeNode.right = dfs(nums, mid+1, right);

			return treeNode;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}