package leetcode.editor.datastructure.tree;

/**
 * 二叉树树节点定义
 * @param <T>
 */
public class TreeNode<T> {
    public T data; //节点数据
    public TreeNode<T> left; //指向左子树
    public TreeNode<T> right; //指向右子树

    public TreeNode() {}

    public TreeNode(T data) {
        this(data, null, null);
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
