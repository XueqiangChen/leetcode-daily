package leetcode.editor.datastructure.sort;

public class HeapSort implements SortStrategy{

	@Override
	public void sort(int[] array, int n) {
		heapSort(array, n);
	}

	private void heapSort(int[] array, int n) {
		int i, temp;
		for (i = (n-1)/2; i >= 0; i--){//从有儿子的最后一个节点开始
			precDown(array, i, n);
		}

		for (i = n-1; i > 0; i--) {
			// 将堆顶元素和当前堆的最后一个元素换位
			temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			// 将有i个元素的新堆从根结点向下过滤调整
			precDown(array, 0, i);
		}
	}

	private void precDown(int[] array, int i, int n) {
		// 对 array 中的前 n 个元素从第 i 个元素开始向下迁移调整
		int child, temp;

		for (temp = array[i]; (2*i + 1) < n; i = child) {
			// 左子节点
			child = 2*i + 1;
			// 左子节点不是最后一个节点，判断右子节点是否大于左子节点
			if (child != n-1 && array[child + 1] > array[child]) {
				// child指向左右子结点中的较大值
				child++;
			}
			if (temp < array[child]) {
				//移动child元素到上层
				array[i] = array[child];
			} else {
				break;
			}

			// 将temp放到合适位置
			array[i] = temp;
		}
	}
}
