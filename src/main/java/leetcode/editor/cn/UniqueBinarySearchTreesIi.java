//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 620 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            // 0 <= n <= 8
            if (n == 0) {
                return new ArrayList<>();
            }

            List<TreeNode> answers = new ArrayList<>();
            // 从1—n选择枚举出所有的数字，作为根结点，假设此时根结点的值为i，则
            // 左子树的取值为 1~i-1,右子树的取值为i+1~n
            // 那么，利用递归算法，每次从左右子树中取出一个值，不断做。
            // 最后，

            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}