package leetcode.editor.datastructure.dp;

/**
 *问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class FrogJumping {

	public static void main(String[] args) {
		System.out.println(method(3));
	}


	public static int method(int n) {//n个台阶
		// 找出初始条件
		if (n <= 2) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		// 定义数组元素的含义
		for (int i = 3; i <= n; i++) {
			// 找出数组元素间的关系式
			// 跳上一个 i 级的台阶总共有 dp[i] 种跳法
			dp[i] = dp[i-2] + dp[i-1];
		}

		return dp[n];
 	}
}
