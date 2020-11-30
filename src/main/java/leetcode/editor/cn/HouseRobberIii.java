//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 648 👎 0


package leetcode.editor.cn;

import java.util.*;

public class HouseRobberIii {
	public static void main(String[] args) {
		Solution solution = new HouseRobberIii().new Solution();
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
		Map<TreeNode, Integer> f = new HashMap<>();
		Map<TreeNode, Integer> g = new HashMap<>();

		public int rob(TreeNode root) {
			dfs(root);
			return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
		}

		public void dfs(TreeNode node) {
			if (node == null) {
				return;
			}
			dfs(node.left);
			dfs(node.right);
			f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
			g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}