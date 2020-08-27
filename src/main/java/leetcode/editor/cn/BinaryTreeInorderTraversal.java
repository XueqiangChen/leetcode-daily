//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 638 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

        TreeNode rLeaf = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, rLeaf, null);
        TreeNode root = new TreeNode(1, null, node2);
        List<Integer> list = solution.inorderTraversal(root);

        list.forEach(System.out::println);
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
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            TreeNode tmpTree = root;
            Stack<TreeNode> stack = new Stack<>();
            while ( tmpTree != null || !stack.isEmpty()) {
                // 一直向左并将沿途结点压入堆栈
                while (tmpTree != null) {
                    stack.push(tmpTree);
                    tmpTree = tmpTree.left;
                }

                if (!stack.isEmpty()) {
                    // 结点弹出堆栈
                    tmpTree = stack.pop();
                    // 访问结点
                    list.add(tmpTree.val);
                    // 转向右子树
                    tmpTree = tmpTree.right;
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}