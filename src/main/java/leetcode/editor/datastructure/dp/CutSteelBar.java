package leetcode.editor.datastructure.dp;

/**
 * 切割钢条问题: https://blog.csdn.net/u013309870/article/details/75193592
 */
public class CutSteelBar {

	public static void main(String[] args) {
		int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		int result = cut(prices, 4);
		System.out.println(result);
	}

	// 递归解决
	public static int cut(int[] p, int n) {
		if (n == 0)
			return 0;
		int q = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			q = Math.max(q, p[i - 1] + cut(p, n - i));
		}
		return q;
	}

	public static int cutMemo(int[] p) {
		int[] r = new int[p.length + 1];//备忘录
		for (int i = 0; i <= p.length; i++)//备忘录数组初始化为-1
			r[i] = -1;
		return cut(p, p.length, r);
	}

	public static int cut(int[] p, int n, int[] r) {
		// q 是最后要返回的值
		int q = -1;
		// 如果备忘录数组中已经有这个值，就直接返回，避免再迭代
		if (r[n] >= 0)
			return r[n];
		// 长度为0的时候
		if (n == 0)
			q = 0;
		else {
			// 这段逻辑就是正常的递归
			for (int i = 1; i <= n; i++)
				q = Math.max(q, cut(p, n - i, r) + p[i - 1]);
		}
		// 将递归的某段结果存入备忘录
		r[n] = q;

		return q;
	}

	public static int buttom_up_cut(int[] p) {
		// 初始化一个备忘录数组
		int[] r = new int[p.length + 1];
		for (int i = 1; i <= p.length; i++) {
			int q = -1;
			//①
			for (int j = 1; j <= i; j++)
				q = Math.max(q, p[j - 1] + r[i - j]);
			r[i] = q;
		}
		return r[p.length];
	}
}
