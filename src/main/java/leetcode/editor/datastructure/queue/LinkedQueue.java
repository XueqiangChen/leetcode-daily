package leetcode.editor.datastructure.queue;

import leetcode.editor.datastructure.Node;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> front; //指向队头节点

    private Node<T> rear; //指向队尾节点

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void add(T data) {
        Node<T> node = new Node<>(data, null);
        if (this.front == null) {//空队列插入
            this.front = node;
        } else {//非空队列,尾部插入
            this.rear.next = node;
        }
        this.rear = node;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public T delete() {
        Node<T> frontCell;
        T frontElem;

        if (this.front == null) {
            System.out.println("队列为空");
            return null;
        }
        frontCell = front;
        if (front == rear) //若队列只有一个元素
            front = rear = null; //删除后队列置为空
        else
            front = front.next();//front移动到下一个元素
        frontElem = frontCell.data;
        return frontElem;
    }
}
