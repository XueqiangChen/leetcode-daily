package leetcode.editor.datastructure.queue;

public interface Queue<T> {
    void add(T data);
    boolean isEmpty();
    T delete();
}
