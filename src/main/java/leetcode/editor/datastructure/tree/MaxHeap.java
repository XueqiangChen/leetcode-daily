package leetcode.editor.datastructure.tree;

public class MaxHeap extends Heap {

    public MaxHeap(int maxSize, int value) {
        super(maxSize, value);
    }

    public boolean insert(int element) {
        // 将元素X插入最大堆H，其中H->Data[0]已经定义为哨兵
        int i;

        if (isFull()) {
            System.out.println("最大堆已满");
            return false;
        }
        i = ++this.size; // i指向插入后堆中的最后一个元素的位置
        for (; this.data[i / 2] < element; i /= 2) {
            data[i] = data[i / 2]; // 向下过滤结点，对调父结点的位置
        }
        data[i] = element; // 将X插入
        return true;
    }

    public int deleteMax() {
        // 从最大堆中取出键值为最大的元素，并删除一个结点
        int parent, child;
        int maxItem, temp;//maxItem-堆顶元素，temp-临时变量
        if (isEmpty()) {
            System.out.println("最大堆已经为空");
            return -1;
        }

        maxItem = this.data[1];//取出根结点最大值
        // 用最大堆中的最后一个元素从根结点开始向上过滤下层结点
        temp = this.data[this.size--];
        for (parent = 1; parent * 2 < this.size; parent = child) {
            child = parent * 2; // 左儿子的位置
            if (child != this.size && this.data[child] < this.data[child + 1]) {
                child++; //child 指向左右结点的较大者
            }
            if (temp > this.data[child]) {//找到位置了
                break;
            } else {//将子结点与父节点对换
                this.data[parent] = this.data[child];
            }
        }
        this.data[parent] = temp;
        return maxItem;
    }

    //*----------- 建造最大堆 -----------*//*
    private void preDown(int p) {
        //* 下滤：将H中以Data[p]为根的子堆调整为最大堆 *//*
        int parent, child;
        int temp;

        temp = data[p]; //* 取出根结点存放的值 *//*
        for (parent = p; parent * 2 <= size; parent = child) { //这个过程与删除的过程一样
            child = parent * 2;
            if ((child != size) && (data[child] < data[child + 1]))
                child++;  //* Child指向左右子结点的较大者 *//*
            if (temp >= data[child]) break; //* 找到了合适位置 *//*
            else  //* 下滤X *//*
            data[parent] = data[child];
        }
        data[parent] = temp;
    }

    public void buildHeap() {
        //* 调整Data[]中的元素，使满足最大堆的有序性  *//*
        //* 这里假设所有Size个元素已经存在Data[]中 *//*

        int i;

        //* 从最后一个结点的父节点开始，到根结点1 *//*
        for (i = this.size / 2; i > 0; i--) {
            preDown(i);
        }
    }
}
