package leetcode.editor.datastructure;

/**
 * 单向链表的结构，包含两个属性：
 * data -> 节点的数据
 * next -> 指向下一个节点的指针
 * @param <T>
 */
public class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node<T> next() {
        return this.next;
    }

}
