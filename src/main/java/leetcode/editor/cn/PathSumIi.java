//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 369 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
        	List<List<Integer>> result = new ArrayList<>();
        	dfs(root, sum, new ArrayList<>(), result);
        	return result;
		}

		public void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
			//如果节点为空直接返回
			if (root == null)
				return;
			//把当前节点值加入到list中
			list.add(new Integer(root.val));
			//如果到达叶子节点，就不能往下走了，直接return
			if (root.left == null && root.right == null) {
				//如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
				//要把它放到result中
				if (sum == root.val)
					result.add(new ArrayList<>(list));
				//注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
				//不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
				//一个结点的值给remove掉。
				list.remove(list.size() - 1);
				//到叶子节点之后直接返回，因为在往下就走不动了
				return;
			}
			//如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
			//下一步的时候，sum值要减去当前节点的值
			dfs(root.left, sum - root.val, list, result);
			dfs(root.right, sum - root.val, list, result);
			//我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
			//我们把这个值使用完之后还要把它给移除，这就是回溯
			list.remove(list.size() - 1);
		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}