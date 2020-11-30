package leetcode.editor.datastructure.sort;

public class SortContext {

	private SortStrategy sortStrategy;

	public SortContext(SortStrategy sortStrategy) {
		this.sortStrategy = sortStrategy;
	}

	public void sort(int[] array, int length) {
		sortStrategy.sort(array, length);
	}
}
