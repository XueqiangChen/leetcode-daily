//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 240 👎 0


package leetcode.editor.cn;

import java.util.jar.JarEntry;

public class ZhongJianErChaShuLcof {
	public static void main(String[] args) {
		Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder.length == 0 || inorder.length == 0) {
				return null;
			}

			return generateTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
		}

		private TreeNode generateTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
			if (preStart > preEnd) {
				return null;
			}

			int rootPos=0, rootVal = 0;
			for (int i = preStart; i <= preEnd; i++) {
				rootVal = preorder[i];
				for (int j = inStart; j <= inEnd; j++) {
					if (rootVal == inorder[j]) {
						rootPos = j;
						break;
					}
				}
			}

			TreeNode treeNode = new TreeNode(rootVal);
//			treeNode.left = generateTree(preorder, rootPos, )
			return null;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}