//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 210 👎 0


package leetcode.editor.cn;


public class SumRootToLeafNumbers {
	public static void main(String[] args) {
		Solution solution = new SumRootToLeafNumbers().new Solution();
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
		public int sumNumbers(TreeNode root) {
			// method1
			/*List<String> result = new ArrayList<>();
			int sum = 0;
			dfs(root, result, new StringBuilder());
			for (String num : result) {
				sum += Integer.parseInt(num);
			}
			return sum;*/
			return dfs(root, 0);
		}

		private int dfs(TreeNode root, int i) {
			if(root == null) {
				return 0;
			}

			int temp = i * 10 + root.val;
			if (root.left==null && root.right==null) {
				return temp;
			}
			return dfs(root.left, temp) + dfs(root.right, temp);
		}
		// method1
		/*private void dfs(TreeNode root, List<String> result, StringBuilder sb) {
			if (root == null) {
				return;
			}

			sb.append(root.val);
			if (root.right == null && root.left == null) {
				result.add(sb.toString());
				sb.deleteCharAt(sb.length()-1);
				return;
			}

			dfs(root.left, result, sb);
			dfs(root.right, result, sb);
			sb.deleteCharAt(sb.length()-1);
		}*/
	}
	//leetcode submit region end(Prohibit modification and deletion)

}