package leetcode.editor.datastructure.dp;

public class Fibonacci {

	public static void main(String[] args) {
		int result = fib(18);
		System.out.println("斐波那契数为: " + result);

		result = fibDp(18);
		System.out.println("动态规划计算斐波那契数列: " + result);

		result = fibDpOpt(18);
		System.out.println("动态规划计算斐波那契数列优化版: " + result);
	}

	// 递归版
	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1 || n == 2) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	// 递归备忘录版
	public static int fibMem(int n) {
		if (n < 1) {
			return 0;
		}

		int[] mem = new int[n+1];
		for (int i = 0; i <= n; i++) {
			mem[i] = 0;
		}
		return helper(n, mem);
	}

	private static int helper(int n, int[] mem) {
		// base case
		if (n == 1 || n == 2) {
			return 1;
		}
		// 已经计算过的直接返回
		if (mem[n] != 0) {
			return mem[n];
		}

		mem[n] = helper(n - 1, mem) + helper(n - 2, mem);

		return mem[n];
	}

	// 动态规划版
	public static int fibDp(int n) {
		if (n < 1) {
			return 0;
		}

		// dp table 一维
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = 0;
		}
		// 基本情况，初始值
		dp[1] = 1;
		dp[2] = 1;

		// 数组之间的关系
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	// 动态规划优化，只需要记录两个状态，之前的和当前的
	public static int fibDpOpt(int n) {
		if (n < 1) {
			return 0;
		}

		if (n == 1 || n == 2) {
			return 1;
		}

		int pre = 1;
		int current =1;
		int sum = 0;
		for (int i = 3; i <= n; i++) {
			sum  = pre + current;
			pre = current;
			current = sum;
		}

		return sum;
	}
}
