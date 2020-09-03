package leetcode.editor.datastructure.tree;

public class BinarySearchTree<T extends Comparable<? super T>>{

    private TreeNode<T> rootTree;

    // 构造一棵空树
    public BinarySearchTree() {
        this.rootTree = null;
    }

    public BinarySearchTree(TreeNode<T> rootTree) {
        this.rootTree = rootTree;
    }

    // 判断二叉查找树是否为空
    public boolean isEmpty() {
        return rootTree == null;
    }

    // 在二叉搜索树中查找某个值
    public TreeNode<T> find(T x, TreeNode<T> bst) {
        if (bst == null) {
            System.out.println("树为空，查找失败！");
            return null; //查找失败
        }

        int result = x.compareTo(bst.data);
        if (result > 0) {
            // x 大于根结点的值，向右子树递归查找
            return find(x, bst.right);
        } else if (result < 0) {
            // x 小于根结点的值，向左子树递归查找
            return find(x, bst.left);
        } else {
            // 找到 x 的值，直接返回结点所在的指针
            return bst;
        }
    }

    // 查找的非递归实现
    public TreeNode<T> findNonRecursive(T x, TreeNode<T> bst) {
        while (bst != null) {
            int result = x.compareTo(bst.data);
            if (result > 0) {
                // 向右子树中移动，继续查找
                bst = bst.right;
            } else if (result < 0) {
                // 向左子树中移动，继续查找
                bst = bst.left;
            } else {
                // x == bst.data
                // 查找成功，返回结点的找到结点的地址
                return bst;
            }
        }
        // 查找失败
        return null;
    }

   // 查找树的最小值
    public TreeNode<T> findMin(TreeNode<T> bst) {
        if (bst == null) {
            // 空的二叉搜索树，返回NULL
            return null;
        } else if (bst.left == null) {
            // 找到最左叶结点并返回
            return bst;
        } else {
            // 沿左分支继续查找
            return findMin(bst.left);
        }
    }

    // 查找树的最大值
    public TreeNode<T> findMax(TreeNode<T> bst) {
        if (bst == null) {
            // 空的二叉搜索树
            return null;
        } else if (bst.right == null) {
            // 找到最右的叶结点并返回
            return bst;
        } else {
            // 沿右分支继续查找
            return findMax(bst.right);
        }
    }

    // 最小值非递归实现
    public TreeNode<T> findMinNonRecursive(TreeNode<T> bst) {
        if (bst != null) {
            while (bst.left != null) {
                // 沿左分支继续查找，直到最右叶结点
                bst = bst.left;
            }
        }

        return bst;
    }

    // 查找最大值非递归实现
    public TreeNode<T> findMaxNonRecursive(TreeNode<T> bst) {
        if (bst != null) {
            while (bst.right != null) {
                // 沿右分支继续查找，直到最右叶结点
                bst = bst.right;
            }
        }

        return bst;
    }

    // 插入操作
    public TreeNode<T> insert(T x, TreeNode<T> bst) {
        if (bst == null) {
            // 若原树为空，生成并返回一个结点的二叉搜索树
            bst = new TreeNode<>();
            bst.data = x;
            bst.left = bst.right = null;
        } else {
            // 开始查找要插入元素的位置
            int result = x.compareTo(bst.data);
            if (result < 0) {
                // 递归插入左子树
                bst.left = insert(x, bst.left);
            } else if (result > 0) {
                // 递归插入右子树
                bst.right = insert(x, bst.right);
            } /*else {
                // x 元素已经存在, 不做任何操作
                //
            }*/
        }

        return bst;
    }

    // 删除操作
    public TreeNode<T> delete(T x, TreeNode<T> bst) {
        TreeNode<T> tmp;
        if (bst == null) {
            System.out.println("树为空，要删除的元素未找到！");
            return null;
        } else if (x.compareTo(bst.data) < 0) { //左子树递归删除
            bst.left = delete(x, bst.left);
        } else if (x.compareTo(bst.data) > 0) {
            bst.right = delete(x, bst.right); //右子树递归删除
        } else { //找到要删除的节点
            if (bst.left != null && bst.right != null) { //被删除结点有左右两个子结点
                tmp = findMin(bst.right);
                // 在右子树中找最小的元素填充删除结点
                bst.data = tmp.data;
                bst.right = delete(bst.data, bst.right);
            } else { // 被删除结点有一个或无子结点
                if (bst.left == null) {
                    // 有右孩子或无子结点
                    bst = bst.right;
                } else if (bst.right == null) {
                    bst = bst.left;
                }
            }
        }

        return bst;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "rootTree=" + rootTree.data +
                '}';
    }

    public static void main(String[] args) {
        // build a test tree, and delete node 33
        //    30
        //   /  \
        //  15  41
        //     /  \
        //    33   50
        //     \
        //      35
        TreeNode<Integer> node1 = new TreeNode<>(35, null, null);
        TreeNode<Integer> node2 = new TreeNode<>(33, null, node1);
        TreeNode<Integer> node3 = new TreeNode<>(50, null, null);
        TreeNode<Integer> node4 = new TreeNode<>(41, node2, node3);
        TreeNode<Integer> node5 = new TreeNode<>(15, null, null);
        TreeNode<Integer> root = new TreeNode<>(30, node5, node4);

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        System.out.println("find 33 node is in " + binarySearchTree.find(33, root).data);
        System.out.println("max value is " + binarySearchTree.findMax(root).data);
        System.out.println("min value is " + binarySearchTree.findMin(root).data);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        TreeNode<Integer> insertNode = binarySearchTree.insert(34, root);
        binaryTree.levelOrderTraveral(insertNode);
        System.out.println();
        TreeNode<Integer> deleteNode = binarySearchTree.delete(41, root);
        binaryTree.levelOrderTraveral(deleteNode);
    }
}
