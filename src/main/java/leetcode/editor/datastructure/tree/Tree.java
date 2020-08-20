package leetcode.editor.datastructure.tree;

public interface Tree<T> {

    /**
     * 判别二叉树是否为空
     * @param treeNode
     * @return
     */
    boolean isEmpty(TreeNode<T> treeNode);

    /**
     * 遍历，按某顺序访问每个结点
     * 遍历方法有四种：
     * 1. 先序遍历：preOrderTraversal
     * 2. 中序遍历：inOrderTraversal
     * 3. 后序遍历：postOrderTraversal
     * 4. 层次遍历：levelOrderTraversal
     * @param treeNode
     */
    void traversal(TreeNode<T> treeNode);

    /**
     * 创建一个二叉树
     * @return
     */
    TreeNode<T> createBinTree();
}
