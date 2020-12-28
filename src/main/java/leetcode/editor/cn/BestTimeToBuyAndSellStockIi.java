// leetcode-122
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 1013 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIi {
	public static void main(String[] args) {
		Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
		int[] testArr = new int[]{7, 1, 5, 3, 6, 4};
		System.out.println(solution.maxProfit(testArr));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 方法一：暴力递归，n次买卖的问题，可以通过穷举的方式得到最优解，但是在测试用例过大的时候，会出现超时
		 * @param prices
		 * @return
		 */
		public int maxProfit1(int[] prices) {
			int maxProfit = 0;
			for (int buy = 0; buy < prices.length; buy++) {//买入股票
				for (int sell = buy + 1; sell < prices.length; sell++) {//卖出股票
					// 确定了第一次买入和卖出的时间后，后面的多次买卖都是在第二次卖出股票之后进行，
					// 计算的方法是一致，都是比较当前的最大和n次买卖之后的最大值之和，即
					// 其中递归计算prices[sell+1~price.length]的利润，加上第一次买卖的利润，与当前的最大
					// 利润比较，取一个最大值。
					maxProfit = Math.max(maxProfit,
							maxProfit1(Arrays.copyOfRange(prices, sell + 1, prices.length)) + prices[sell] - prices[buy]);
				}
			}

			return maxProfit;
		}

		/**
		 * 方法二：
		 * 基于上面的暴力穷举的方法，做两个改进：
		 * 1. 固定卖出时间，寻找最小的费用买入，可减少一次循环，参考121
		 * 2. 添加备忘录，减少递归调用
		 * @param prices
		 * @return
		 */
		public int maxProfit2(int[] prices) {

			int[] memo = new int[prices.length];

			return dp(prices, 0, memo);
		}

		private int dp(int[] prices, int start, int[] memo) {
			if (start >= prices.length) {
				return 0;
			}
			// 添加备忘录，当要找的值在备忘录数组中的时候，直接返回
			if (memo[start] != 0) {
				return memo[start];
			}

			int maxProfit = 0;
			int minPrice = prices[start];//记录当次的买入最小值
			for (int sell = start + 1; sell < prices.length; sell++) {//卖出股票
				minPrice = Math.min(minPrice, prices[sell]);
				maxProfit = Math.max(maxProfit, dp(prices, sell + 1, memo) + prices[sell] - minPrice);
			}
			memo[start] = maxProfit;
			return maxProfit;
		}

		/**
		 * 方法三:
		 * 贪心算法
		 * @param prices
		 * @return
		 */
		public int maxProfit3(int[] prices) {
			int maxProfit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) {
					maxProfit += prices[i] - prices[i-1];
				}
			}
			return maxProfit;
		}

		/**
		 * 方法四: 使用状态转移框架
		 * 先列出两个通用的状态转移方程
		 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
		 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
		 *
		 * 在这道题目中，由于k是不限次数的，即k可以是无穷大，那么k和k-1是一样的
		 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
		 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
		 *             = max(dp[i-1][k][1], dp[i-1][k][0]-prices[i])
		 * 我们发现，转移方程和k是没有关系的，简化一下方程:
		 * dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
		 * dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
		 * @param prices
		 * @return
		 */
		public int maxProfit(int[] prices) {
			if (prices.length == 0) return 0;
			int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
			for (int i = 0; i < prices.length; i++) {
				int temp = dp_i_0;
				dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
				dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
			}

			return dp_i_0;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}