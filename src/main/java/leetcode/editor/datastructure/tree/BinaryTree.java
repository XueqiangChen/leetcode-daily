package leetcode.editor.datastructure.tree;

import leetcode.editor.datastructure.queue.SeqQueue;
import leetcode.editor.datastructure.stack.Stack;

public class BinaryTree<T> extends TreeNode<T> implements Tree<T>{

    public BinaryTree() {
    }

    public BinaryTree(T data) {
        super(data);
    }

    public BinaryTree(T data, TreeNode<T> left, TreeNode<T> right) {
        super(data, left, right);
    }

    @Override
    public boolean isEmpty(TreeNode<T> treeNode) {
        return false;
    }

    @Override
    public void traversal(TreeNode<T> treeNode) {

    }

    @Override
    public TreeNode<T> createBinTree() {
        return null;
    }

    /**
     * 先序遍历递归实现：
     * 1. 访问根结点
     * 2. 先序遍历其左子树
     * 3. 先序遍历其右子树
     * @param binTree
     */
    public void preOrderTraversal(TreeNode<T> binTree) {
        if (binTree != null) {
            System.out.println(binTree.data);
            preOrderTraversal(binTree.left);
            preOrderTraversal(binTree.right);
        }
    }

    /**
     * 中序遍历递归实现：
     * 1. 中序遍历其左子树
     * 2. 访问根结点
     * 3. 中序遍历其右子树
     * @param binTree
     */
    public void inOrderTraversal(TreeNode<T> binTree) {
        if (binTree != null) {
            inOrderTraversal(binTree.left);
            System.out.println(binTree.data);
            inOrderTraversal(binTree.right);
        }
    }

    /**
     * 后序遍历递归实现：
     * 1. 后序遍历其左子树
     * 2. 后序遍历其右子树
     * 3. 访问根结点
     * @param binTree
     */
    public void postOrderTraversal(TreeNode<T> binTree) {
        if (binTree != null) {
            postOrderTraversal(binTree.left);
            postOrderTraversal(binTree.right);
            System.out.println(binTree.data);
        }
    }


    /**
     * 中序遍历的非递归实现
     * @param binTree
     */
    public void nonRecursiveInOrderTraversal(TreeNode<T> binTree) {
        TreeNode<T> tmpTree = binTree;
        Stack<TreeNode<T>> stack = new Stack<>();
        while ( tmpTree != null || !stack.isEmpty(stack)) {
            // 一直向左并将沿途结点压入堆栈
            while (tmpTree != null) {
                stack.push(tmpTree);
                tmpTree = tmpTree.left;
            }

            if (!stack.isEmpty(stack)) {
                // 结点弹出堆栈
                tmpTree = stack.pop();
                // 访问结点
                System.out.print(tmpTree.data + " ");
                // 转向右子树
                tmpTree = tmpTree.right;
            }
        }
    }

    /**
     * 先序遍历的非递归实现
     * @param binTree
     */
    public void nonRecursivePreOrderTraversal(TreeNode<T> binTree) {
        TreeNode<T> tmpTree = binTree;
        Stack<TreeNode<T>> stack = new Stack<>();
        while ( tmpTree != null || !stack.isEmpty(stack)) {
            // 一直向左并将沿途结点压入堆栈
            while (tmpTree != null) {
                // 访问结点
                System.out.print(tmpTree.data + " ");
                stack.push(tmpTree);
                tmpTree = tmpTree.left;
            }

            if (!stack.isEmpty(stack)) {
                // 结点弹出堆栈
                tmpTree = stack.pop();
                // 转向右子树
                tmpTree = tmpTree.right;
            }
        }
    }

    /*后序遍历应该把数据两次压入堆栈，第二次pop出来再print
    鉴于没有记录访问次数的结构，我作如下思考
    第二次pop的时候要么右节点是空的，要么右节点刚刚被print
    所以，我需要另一个指针LT来记录被刚刚print的节点*/
    public void nonRecursivepostOrderTraversal(TreeNode<T> binTree) {
        TreeNode<T> tmpTree = binTree;
        TreeNode<T> pt = null;
        Stack<TreeNode<T>> stack = new Stack<>();
        while ( tmpTree != null || !stack.isEmpty(stack)) {
            while (tmpTree != null) {
                stack.push(tmpTree);
                tmpTree = tmpTree.left;
            }
            if (!stack.isEmpty(stack)) {
                // 结点弹出堆栈
                tmpTree = stack.pop();
                if ((tmpTree.right== null)||(tmpTree.right == pt)) {//判断右节点为空或者右节点已经输出
                    System.out.print(tmpTree.data + " ");
                    pt = tmpTree; //记录下上一个被输出的
                    tmpTree = null;
                } else {
                    stack.push(tmpTree);  //第二次入栈（相当于T没有出栈）
                    tmpTree = tmpTree.right;  //转向右子树
                }
            }
        }
    }


    public void levelOrderTraveral(TreeNode<T> binTree) {
        SeqQueue<TreeNode<T>> queue = new SeqQueue<>(20);
        TreeNode<T> t;
        // 若是空树则直接返回
        if (binTree == null) {
            return;
        }
        queue.add(binTree);
        while (!queue.isEmpty()) {
            t = queue.delete();
            System.out.print(t.data + " ");//访问取出队列中的结点
            if (t.left != null) {
                queue.add(t.left);//左结点不为空，则左节点入队
            }
            if (t.right != null) {
                queue.add(t.right); //右节点不为空，则右节点入队
            }
        }
    }

    /**
     * 输出二叉树中的叶子结点
     * @param binTree
     */
    public void preOrderPrintLeaves(TreeNode<T> binTree) {
        if (binTree != null) {
            //叶子结点的左右都为空
            if (binTree.left == null && binTree.right == null) {
                System.out.print(binTree.data + " ");
            }
            preOrderPrintLeaves(binTree.left);
            preOrderPrintLeaves(binTree.right);
        }
    }

    /**
     * 求二叉树的高度
     * @param binTree
     */
    public int postOrderGetHight(TreeNode<T> binTree) {
        int hl, hr, maxH;
        if (binTree != null) {
            hl = postOrderGetHight(binTree.left); //求左子树的高度
            hr = postOrderGetHight(binTree.right); //求右子树的高度
            maxH = Math.max(hl, hr); //取左右子树较大的深度
            return maxH+1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        //叶结点
        TreeNode<String> nodeD = new BinaryTree<>("D", null, null);
        TreeNode<String> nodeE = new BinaryTree<>("E", null, null);
        TreeNode<String> nodeH = new BinaryTree<>("H", null, null);
        TreeNode<String> nodeI = new BinaryTree<>("I", null, null);
        //度为1的结点
        TreeNode<String> nodeF = new BinaryTree<>("F", nodeE, null);
        TreeNode<String> nodeG = new BinaryTree<>("G", null, nodeH);
        //度为2的结点
        TreeNode<String> nodeB = new BinaryTree<>("B", nodeD, nodeF);
        TreeNode<String> nodeC = new BinaryTree<>("C", nodeG, nodeI);
        //根结点
        TreeNode<String> nodeA = new BinaryTree<>("A", nodeB, nodeC);

        BinaryTree<String> binaryTree = new BinaryTree<>();
        binaryTree.nonRecursiveInOrderTraversal(nodeA);
        System.out.println();
        binaryTree.nonRecursivePreOrderTraversal(nodeA);
        System.out.println();
        binaryTree.nonRecursivepostOrderTraversal(nodeA);
        System.out.println();
        binaryTree.levelOrderTraveral(nodeA);
        System.out.println();
        binaryTree.preOrderPrintLeaves(nodeA);
        System.out.println();
        System.out.println("树的高度为：" + binaryTree.postOrderGetHight(nodeA));
    }

}
