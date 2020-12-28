// leetcode-309
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 626 👎 0


package leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown {
	public static void main(String[] args) {
		Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
		int[] testArray = new int[]{1,2,3,0,2};
		System.out.println(solution.maxProfit(testArray));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxProfit(int[] prices) {
			int[] memo = new int[prices.length];
			return dp(prices, memo, 0);
		}

		private int dp(int[] prices, int[] memo, int start) {

			if (start >= prices.length) return 0;
			if (memo[start] != 0) return memo[start];
			int maxProfit = 0;
			int minPrice = prices[start];
			for (int sell = start + 1; sell < prices.length; sell++) {
				minPrice = Math.min(minPrice, prices[sell]);
				// 有一天的冷冻期，所以 sell 要加2
				maxProfit = Math.max(maxProfit, dp(prices, memo, sell+2) + prices[sell] - minPrice);
			}
			memo[start] = maxProfit;
			return maxProfit;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}