package leetcode.editor.datastructure.stack;

public interface IStack<T> {

    /**
     * 判断堆栈是否已满
     *
     * @param stack
     * @param maxSize
     * @return
     */
    boolean isFull(Stack<T> stack, int maxSize);

    /**
     * 将元素 item 压入堆栈
     *
     * @param item
     */
    void push(T item);

    /**
     * 判断堆栈是否为空
     *
     * @param stack
     * @return
     */
    boolean isEmpty(Stack<T> stack);

    /**
     * 删除并返回栈顶元素
     *
     * @return
     */
    T pop();
}
