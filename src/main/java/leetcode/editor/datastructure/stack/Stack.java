package leetcode.editor.datastructure.stack;

public class Stack<T> implements IStack<T>{

    public final static int DEFAULT_SIZE = 10;

    private int maxSize; //数组大小

    private T[] data; //一维数组

    private int top; //栈顶元素的位置

    public Stack() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
        this.top = 0;
        this.maxSize = DEFAULT_SIZE;
    }

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = 0;
        this.data = (T[]) new Object[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public boolean isFull(Stack<T> seqStack, int maxSize) {
        return seqStack.top == maxSize - 1;
    }

    @Override
    public void push(T item) {
        if (this.top == maxSize) {
            System.out.println("堆栈满");
        } else {
            this.data[++this.top] = item;
        }
    }

    @Override
    public boolean isEmpty(Stack<T> seqStack) {
        return seqStack.top == 0;
    }

    @Override
    public T pop() {
        if (this.top == -1) {
            System.out.println("堆栈空");
            return null;
        } else {
            return this.data[this.top--];
        }
    }
}
