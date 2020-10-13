package leetcode.editor.datastructure.questions;

import leetcode.editor.datastructure.tree.MinHeap;

import java.util.Scanner;

/**
 * 将一系列给定数字插入一个初始为空的小顶堆H[]。随后对任意给定的下标 i，打印从 H[i] 到根结点的路径
 *
 * ### 输入样例：
 * 5 3
 * 46 23 26 24 10
 * 5 4 3
 *
 * ### 输出样例:
 * 24 23 10
 * 46 23 10
 * 26 10
 */
public class RoadOfHeap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 解题思路
        // 1. 读入 n 和 m
        // 2. 根据输入序列建堆
        // 3. 对 m 个要求：打印到根的路劲
        int dataNum = scanner.nextInt();
        int indexNum = scanner.nextInt();
        System.out.println("数据个数: " + dataNum + " " + "下标个数: " + indexNum);

        // 堆初始化
        MinHeap minHeap = new MinHeap(dataNum, Integer.MIN_VALUE);
        // 建堆, 以逐个插入方式建堆
        for (int i = 0; i < dataNum; i++) {
            minHeap.insert(scanner.nextInt());
        }

        int indexData;
        for (int i = 0; i < indexNum; i++) {
            indexData = minHeap.getData()[scanner.nextInt()];
            System.out.println(indexData);
            while (indexData > 1) {
                indexData /= 2;
                System.out.println(minHeap.getData()[scanner.nextInt()]);
            }
            System.out.println();
        }
    }
}
