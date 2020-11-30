//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 315 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeIi {
	public static void main(String[] args) {
		Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();

		Node secLL = new Node(4, null, null, null);
		Node secLR = new Node(5, null, null, null);
		Node secRR = new Node(7, null, null, null);
		Node rootLeft = new Node(2, secLL, secLR, null);
		Node rootRight = new Node(3, null, secRR, null);

		Node root = new Node(1, rootLeft, rootRight, null);

		solution.connect(root);

	}

	// Definition for a Node.
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		// 方法一：
		// 采用广度优先遍历的实现方式，借助队列层序遍历二叉树，将每层的节点存入到list中，
		// 遍历list的元素，将相邻两个元素连接起来，返回结果
		public Node connect1(Node root) {
			if (root == null) {
				return null;
			}

			List<List<Node>> resultLists = new ArrayList<>();
			Queue<Node> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				List<Node> tmpList = new ArrayList<>();
				int size = queue.size();
				for (int i = 1; i <= size; i++) {
					Node node = queue.poll();
					tmpList.add(node);
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				resultLists.add(tmpList);
			}

			for (List<Node> nodes : resultLists) {
				for (int i = 0; i < nodes.size(); i++) {
					Node current = nodes.get(i);
					if ((i + 1) < nodes.size()) { //防止数组越界
						current.next = nodes.get(i + 1);
					}
				}
			}

			return root;
		}

		// 方法二: 采用深度优先遍历的方式
		// 先将自己的左右孩子连接，然后连接相邻的跨节点。
		// 最麻烦的地方是跨节点的连接，如果两个节点分别在最左和最右，中间没有任何节点，那么该如何做？如下所示：
		//                1
		//               /  \
		//              2    3
		//             / \    \
		//            4   5    6
		//           /          \
		//          7            8
		//
		public Node connect(Node root) {
			if (root == null) {
				return null;
			}

			List<Node> tmpList = new ArrayList<>();
			connetTwo(root.left, root.right, tmpList);

			return root;
		}

		private void connetTwo(Node left, Node right, List<Node> tmpList) {

		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}