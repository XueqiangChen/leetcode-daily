package leetcode.editor.datastructure.sort;

/**
 * 简单选择排序
 */
public class SelectionSort implements SortStrategy{

	@Override
	public void sort(int[] array, int n) {
		selectionSort(array, n);
	}

	private void selectionSort(int[] array, int n) {
		if (array.length == 0) {
			return;
		}

		int i, j, min, temp;

		for (i = 0; i < n - 1; i++) {
			min = i;
			for (j = i+1; j < n; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			//将第i个元素与最小元素交换
			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
