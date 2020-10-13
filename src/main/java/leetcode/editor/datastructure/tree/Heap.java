package leetcode.editor.datastructure.tree;

import lombok.Data;

@Data
public abstract class Heap {
    // 堆的类型定义
    protected int[] data; //存储元素的数组
    protected int size;//堆中当前元素个数
    protected int capacity; //堆的最大容量

    public Heap() {
        this.size = 0;
        this.capacity = 0;
    }

    public Heap(int[] data, int capacity, int value) {
        this.data = data;
        this.size = 0;
        this.capacity = capacity;
        this.data[0] = value;
    }

    public Heap(int maxSize, int value) {
        this.data = new int[maxSize + 1];//最大元素从1开始
        this.size = 0;
        this.capacity = maxSize;
        this.data[0] = value;// 定义哨兵，为大于最大堆中所有可能元素的值(或小于最小堆中的所有元素)
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public abstract boolean insert(int element);
}
