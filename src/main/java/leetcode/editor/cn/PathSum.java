//leetcode-112:给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 447 👎 0


package leetcode.editor.cn;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
        	// mothod1
            /*if (root == null) {
                return false;
            }

            int tmp = 0;
            return preOrderTraversal(root, sum, tmp);*/

			if(root == null) {
				return false;
			}

			if (root.right == null && root.left == null) {
				return sum == root.val;
			}

			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }

        // method1
        /*private boolean preOrderTraversal(TreeNode root, int sum, int tmp) {
            if (root == null) {
                return false;
            }
            tmp += root.val;
            if (root.left == null && root.right == null) {
                return tmp == sum;
            }

            boolean left = preOrderTraversal(root.left, sum, tmp);
            boolean right = preOrderTraversal(root.right, sum, tmp);
            return left || right;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)
}