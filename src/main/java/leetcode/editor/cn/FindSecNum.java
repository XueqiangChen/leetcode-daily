package leetcode.editor.cn;

/**
 * 从数组中找到第二大的数
 */
public class FindSecNum {

	public static void main(String[] args) {
		int[] array = new int[]{13, 4, 9, 1, 0, 43, 20};
//		System.out.println("排序输出第二大元素: " + findSecBySort(array));
		System.out.println("不排序输出第二大元素: " + findSecNum(array));
	}

	// 方法一：通过排序，遍历找到第二大的数
	// 排序算法使用快速排序，快速排序的时间复杂度为O(nlogn)
	public static int findSecBySort(int[] arr) {
		if (arr.length < 1) {
			return -1;
		}

		quickSort(arr, 0, arr.length-1);
		int secNum = -1;
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 2) {
				secNum = arr[i];
			}
		}

		return secNum;
	}

	private static void quickSort(int[] arr, int left, int right) {
		int pivot = Median3( arr, left, right ); // 选基准
		int low = left;
		int high = right - 1;
		while (true) { //将序列中比基准小的移到基准左边，大的移到右边
			while (arr[++low] < pivot);
			while (arr[--high] > pivot);
			if ( low < high ) {
				swap(arr[low], arr[high]);
			} else {
				break;
			}
		}
		swap(arr[low], arr[right - 1]);// 将基准换到正确的位置
		quickSort( arr, left, low-1 ); //* 递归解决左边 *//*
		quickSort( arr, low+1, right );  //* 递归解决右边 *//*
	}

	public static int Median3( int[] arr, int left, int right )
	{
		int center = (left+right) / 2;
		if ( arr[left] > arr[center] ) {
			swap(arr[left], arr[center]);
		}
		if ( arr[left] > arr[right] ) {
			swap(arr[left], arr[right]);
		}
		if ( arr[center] > arr[right] )
			swap(arr[center], arr[right]);
		//此时A[Left] <= A[Center] <= A[Right]
		swap(arr[center], arr[right-1]); // 将基准Pivot藏到右边
		// 只需要考虑A[Left+1] … A[Right-2]
		return  arr[right-1];// 返回基准Pivot
	}

	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	// 方法二: 不排序，使用两个变量
	public static int findSecNum(int[] arr) {
		if (arr.length < 1) {
			return 0;
		}

		int secMax = Integer.MIN_VALUE;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				secMax = max;
				max = arr[i];
			} else if (arr[i] > secMax) {
				secMax = arr[i];
			}
		}

		return secMax;
	}
}
