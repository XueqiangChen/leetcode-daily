//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 455 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();

        TreeNode pRight = new TreeNode(5, null, null);
        TreeNode pLeft = new TreeNode(15, null, null);
        TreeNode pRoot = new TreeNode(10, pLeft, pRight);

        TreeNode qLRight = new TreeNode(15, null, null);
        TreeNode qLeft = new TreeNode(5, null, qLRight);
        TreeNode qRoot = new TreeNode(10, qLeft, null);

        System.out.println(solution.isSameTree(pRoot, qRoot));

        pRight = new TreeNode(3, null, null);
        pLeft = new TreeNode(2, null, null);
        pRoot = new TreeNode(1, pLeft, pRight);

        TreeNode qRight = new TreeNode(3, null, null);
        qLeft = new TreeNode(2, null, null);
        qRoot = new TreeNode(1, qLeft, qRight);
        System.out.println(solution.isSameTree(pRoot, qRoot));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
           if (p == null && q == null) {
               return true;
           }

           if (p == null || q == null)
               return false;

           if (p.val != q.val) {
               return false;
           }

           return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}