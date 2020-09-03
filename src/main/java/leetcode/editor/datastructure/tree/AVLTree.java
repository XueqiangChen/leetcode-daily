package leetcode.editor.datastructure.tree;

public class AVLTree<T extends Comparable<? super T>> {

    private T data;
    private AVLTree<T> left;
    private AVLTree<T> right;
    private int height; //树高

    public AVLTree(T data, AVLTree<T> left, AVLTree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int postOrderGetHight(AVLTree<T> avlTree) {
        int hl, hr, maxH; // hl:左子树高度，hr:右子树高度，maxH:树高
        if (avlTree != null) {
            hl = postOrderGetHight(avlTree.left); //求左子树的高度
            hr = postOrderGetHight(avlTree.right); //求右子树的高度
            maxH = Math.max(hl, hr); //取左右子树较大的深度
            return maxH+1;
        } else {
            return 0;
        }
    }

    // 左单旋(LL旋转)
    public AVLTree<T> singleLeftRotation(AVLTree<T> a) {
        // 注意：A必须有一个左子结点B
        //将 A与B做左单旋，更新A与B的高度，返回新的根结点B
        AVLTree<T> b = a.left;
        a.left = b.right;
        b.right = a;
        a.height = Math.max(postOrderGetHight(a.left), postOrderGetHight(a.right)) + 1;
        b.height = Math.max(postOrderGetHight(b.left), a.height) + 1;

        return b;
    }

    /*public AVLTree<T> doubleLeftRightRotation(AVLTree<T> a) {
        // 将 x 插入 AVL 树 T 中，并且返回调整后的AVL树
        if ()
    }*/
}
