//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1074 👎 0


package leetcode.editor.cn;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        /**
         * 两个树互为镜像，需要满足两个条件：
         * 它们的两个根结点具有相同的值
         * 每个树的右子树都与另一个树的左子树镜像对称
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }

            if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.val != node2.val) {
                return false;
            }

            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}