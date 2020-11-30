//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 288 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal{
  public static void main(String[] args) {
       Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if(root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 1;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 1; i <= levelSize; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (level % 2 == 0) {
					list.push(node.val);
				} else {
					list.add(node.val);
				}
			}

			level++;

			result.add(list);
		}

		return result;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}