package leetcode.editor.cn;

/**
 * 题目描述：
 * 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。
 * 第一年有 1 只小母牛，从第2年开始，母牛开始生小母牛。
 * 每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 */
public class CrowProduction {

	public static void main(String[] args) {
		CrowProduction.Solution solution = new CrowProduction().new Solution();
		System.out.println(solution.crowProduct(30));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 母牛生产问题：
		 * 根据题目描述，先列出基本的几种情况：
		 * 年份		牛的数量
		 * 1		1
		 * 2		2 //母牛生第一只小牛
		 * 3		3
		 * 4		4
		 * 5		6 //第五年开始，第一只小牛开始生产
		 * 6		9 //第六年，第二只小牛开始生产
		 * 7		13 //第三只小牛卡是生产
		 *
		 * 从第5年开始，牛的数量为前一年的牛的数量，加上前三年的目前数量，因为第一只小牛成熟，开始生产。即，
		 * dp[n] = dp[n-1] + dp[n-3]
		 * @param n 年份
		 * @return 母牛的数量
		 */
		public int crowProduct(int n) {
			if (n <= 0) {
				return 0;
			}

			int[] dp = new int[n + 1];
			dp[1] = 1;
			for(int i = 2; i <= n; i++) {
				if (i <= 4) {
					dp[i] = i;
				} else {
					dp[i] = dp[i - 1] + dp[i - 3];
				}
			}

			return dp[n];
		}
	}
}
