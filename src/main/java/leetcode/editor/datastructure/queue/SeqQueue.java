package leetcode.editor.datastructure.queue;

import java.io.Serializable;

public class SeqQueue<T> implements Queue<T>, Serializable {

    private final static int DEAFULT_SIZE = 10;

    private T elementData[];

    private int front, rear;

    private int size;

    public SeqQueue() {
        elementData = (T[]) new Object[DEAFULT_SIZE];
        front = 0;
        rear = 0;
    }

    public SeqQueue(int size) {
        this.size = size;
        elementData = (T[]) new Object[size];
        front = 0;
        rear = 0;
    }

    public void add(T data) {
        if ((rear + 1) % this.elementData.length == front) {
            System.out.println("队列已满");
            return;
        }
        rear = (rear + 1) % this.elementData.length;
        elementData[rear] = data;
    }

    public boolean isEmpty() {
        return this.elementData.length == 0;
    }

    public T delete() {
        if (front == rear) {
            System.out.println("队列为空");
            return null;
        } else {
            front = (front + 1) % this.elementData.length;
            return elementData[front];
        }
    }
}
