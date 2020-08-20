package leetcode.editor.datastructure.stack;

import leetcode.editor.datastructure.Node;

public class LinkedStack<T> {

    private T data;

    private Node<T> next;

    public LinkedStack() {
        this(null, null);
    }

    public LinkedStack(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean isEmpty(LinkedStack<T> linkedStack) {
        return linkedStack.next == null;
    }

    public void push( T item, LinkedStack<T> linkedStack) { /* 将元素item压入堆栈S */
        Node<T> tmpCell = new Node<>(item, null);
        tmpCell.next = linkedStack.next;
        linkedStack.next = tmpCell;
    }

    public T pop(LinkedStack<T> linkedStack)
    { /* 删除并返回堆栈S的栈顶元素 */
        Node<T> firstCell;
        T topElem;

        if( isEmpty(linkedStack) ) {
            System.out.println("堆栈空");
            return null;
        } else {
            firstCell = linkedStack.next;
            linkedStack.next = firstCell.next;
            topElem = firstCell.data;
            return topElem;
        }
    }
}
