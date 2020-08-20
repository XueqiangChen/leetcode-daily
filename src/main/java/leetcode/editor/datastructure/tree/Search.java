package leetcode.editor.datastructure.tree;

public class Search {

    /**
     * 在表 array 中查找关键字为 k 的数据元素, array 的下标从 1 开始
     *
     * @param array
     * @param k
     * @return
     */
    public int sequentialSearch(int[] array, int k) {
        int i;
        array[0] = k; // 建立哨兵
        for (i = array.length - 1; array[i] != k; i--) ;
        // 查找成功返回所在单元下标，不成功返回0
        return i;
    }

    /**
     * 二分查找
     *
     * @param array
     * @param k
     * @return
     */
    public int binarySearch(int[] array, int k) {
        /*在表Tbl中查找关键字为K的数据元素*/
        int left, right, mid, NoFound = -1;
        left = 1; /*初始左边界*/
        right = array.length; /*初始右边界*/
        while (left <= right) {
            mid = (left + right) / 2; /*计算中间元素坐标*/
            if (k < array[mid]) right = mid - 1; /*调整右边界*/
            else if (k > array[mid]) left = mid + 1; /*调整左边界*/
            else return mid; /*查找成功，返回数据元素的下标*/
        }
        return NoFound; /*查找不成功，返回-1*/
    }


    public static void main(String[] args) {
        Search search = new Search();

        int[] array = new int[9];
        for (int i = array.length - 1; i != 0; i--) {
            array[i] = i;
        }
        int target = 7;
        int result = search.sequentialSearch(array, target);
        System.out.println("search for " + target + " in array is " + result);


        result = search.binarySearch(array, target);
        System.out.println("binary search: " + target + " in array index is: " + result);
    }
}
