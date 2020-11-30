package leetcode.editor.datastructure.sort;

public class SortAlgrothmTest {

	public static void main(String[] args) {
		int[] array = new int[]{6, 5, 3, 8, 1, 7, 2, 4, 9};
		SortStrategy sortStrategy = new SelectionSort();
		SortContext sortContext = new SortContext(sortStrategy);
		sortContext.sort(array, array.length);
		printArray(array);

		array = new int[]{6, 5, 3, 8, 1, 7, 2, 4, 9};
		sortStrategy = new HeapSort();
		sortContext = new SortContext(sortStrategy);
		sortContext.sort(array, array.length);
		System.out.println();
		printArray(array);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
