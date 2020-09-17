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
            return maxH + 1;
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
        a.height = Math.max(postOrderGetHight(a.left), postOrderGetHight(a.right));
        b.height = Math.max(postOrderGetHight(b.left), a.height);

        return b;
    }

    // 右单旋
    public AVLTree<T> singleRightRotation(AVLTree<T> a) {
        // 注意：A 必须有一个右子节点B
        // 将 A 与 B 做右单旋，更新A与B的高度，返回新的根结点B
        AVLTree<T> b = a.right;
        a.right = b.left;
        b.left = a;
        a.height = Math.max(postOrderGetHight(a.left), postOrderGetHight(a.right));
        b.height = Math.max(postOrderGetHight(b.right), a.height);

        return b;
    }

    public AVLTree<T> doubleLeftRightRotation(AVLTree<T> a) {
        // 注意：A必须有一个左子节点B，且B必须有一个右子节点C
        // 将A、B与C做两次单旋，返回新的根结点C

        // 将B与C做右单旋，C被返回
        a.left = singleLeftRotation(a.left);
        // 将A与C做左单旋，C被返回
        return singleLeftRotation(a);
    }

    public AVLTree<T> doubleRightLeftRotation(AVLTree<T> a) {
        // 注意：A必须有一个右子节点B，且B必须有一个左子节点C
        // 将A、B与C做两次单旋，返回新的根结点C

        // 将B与C做左单旋，C被返回
        a.right = singleRightRotation(a.right);
        // 将A与C做右单旋，C被返回
        return singleLeftRotation(a);
    }

    public AVLTree<T> insert(AVLTree<T> t, T x) {
        /* 将X插入AVL树T中，并且返回调整后的AVL树 */
        if (t != null) { /* 若插入空树，则新建包含一个结点的树 */
            t = new AVLTree<>(x, null, null);
            t.height = 0;
        } /* if (插入空树) 结束 */ else if (x.compareTo(t.data) < 0) {
            /* 插入T的左子树 */
            t.left = insert(t.left, x);
            /* 如果需要左旋 */
            if (postOrderGetHight(t.left) - postOrderGetHight(t.right) == 2)
                if (x.compareTo(t.left.data) < 0)
                    t = singleLeftRotation(t);      /* 左单旋 */
                else
                    t = doubleLeftRightRotation(t); /* 左-右双旋 */
        } /* else if (插入左子树) 结束 */ else if (x.compareTo(t.data) > 0) {
            /* 插入T的右子树 */
            t.right = insert(t.right, x);
            /* 如果需要右旋 */
            if (postOrderGetHight(t.left) - postOrderGetHight(t.right) == -2)
                if (x.compareTo(t.right.data) > 0)
                    t = singleRightRotation(t);     /* 右单旋 */
                else
                    t = doubleRightLeftRotation(t); /* 右-左双旋 */
        } /* else if (插入右子树) 结束 */

        /* else X == T->Data，无须插入 */

        /* 别忘了更新树高 */
        t.height = Math.max(postOrderGetHight(t.left), postOrderGetHight(t.right)) + 1;

        return t;
    }
}
