//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 687 👎 0


package leetcode.editor.cn;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth(TreeNode root) {
            // 考虑使用递归的方式，树的高度=max(左子树，右子树)+1
            int hl, hr, maxDepth;//hl:左子树高度，hr：右子树高度
            if (root != null) {
                hl = maxDepth(root.left);
                hr = maxDepth(root.right);
                maxDepth = Math.max(hl, hr);

                return maxDepth + 1;
            } else {
                return 0;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}