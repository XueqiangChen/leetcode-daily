// leetcode-121
//
// 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
// 输出: 5
// 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
// 输出: 0
// 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1325 👎 0


package leetcode.editor.cn;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		Solution solution = new BestTimeToBuyAndSellStock().new Solution();
		int[] testArray = new int[]{7,1,5,3,6,4};
		System.out.println(solution.maxProfit(testArray));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxProfit1(int[] prices) {
			// 动态规划：
			// 用一个值记录最小值，一个值记录最大利润，遍历一遍数组
			// 判断当前 i 位置的值小于最小值的时候，就更新最小值，大于最小值的时候，就计算当前值
			// 和最小值的差值，作为当前利润。当前利润大于最大利润的时候就更新最大利润的值
			int minPrice = Integer.MAX_VALUE;
			int maxProfit = 0;
			for (int price : prices) {
				if (price < minPrice) {
					minPrice = price;
				} else if (price - minPrice > maxProfit) {
					maxProfit = price - minPrice;
				}
			}

			return maxProfit;
		}

		/**
		 * 暴力求解：
		 * 需要找出给定数组中两个数字之间的最大差值，此外，第二个数必须大于第一个数
		 * 通过遍历数组的两个元素，求出每组元素的差值，返回最大的差值
		 * @param prices
		 * @return
		 */
		public int violence(int[] prices) {
			int maxProfit = 0;
			for (int i = 0; i < prices.length - 1; i++) {
				for (int j = i + 1; j < prices.length; j++) {
					maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
				}
			}

			return maxProfit;
		}

		/**
		 * 第三种方法：
		 * 状态转移方程
		 * 通用方程:
		 *
		 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
		 * 解释：情况一
		 * 今天我没有持有股票，有两种可能：
		 * 1. 昨天我没有持有股票，那么今天也没有持有股票，利润不变
		 * 2. 昨天我持有股票，今天没有持有股票，那么就是在今天卖出股票，利润加上今天的股票价格
		 *
		 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
		 * 情况二：
		 * 今天我持有股票，也有两种可能:
		 * 1. 昨天我持有股票，今天继续持有，不卖，利润就不会改变
		 * 2. 昨天我未持有股票，今天打算买股票，那么整体利润要减去今天的股票价格，同时，交易次数k要减1
		 *
		 * Base Case:
		 * 1. dp[-1][k][0] = 0, 因为i是从0开始的，-1表示未开始交易，这时候不可能持有股票，利润为0
		 * 2. dp[-1][k][1] = -infinity, 交易未开始就持有股票的情况是不存在的
		 * 3. dp[i][0][0] = 0, k=0 表示不允许交易，这时候利润为0
		 * 4. dp[i][0][1] = -infinity, 不允许交易的情况下，是不可能持有股票的
		 *
		 * @param prices
		 * @return
		 */
		public int maxProfit(int[] prices) {
			// 交易的次数为1，即k的值固定为1
			// dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1]+prices[i])
			// dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0]-prices[i])
			// k=1的时候，k是没有影响的，可以消掉，简化为:
			// dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
			// dp[i][1] = max(dp[i-1][1], dp[i-1][0][0]-prices[i])
			// 进一步的，我们发现 dp[i-1][0][0] 这个值是在交易次数为0，即不允许交易的情况下，初始值为0，故最后简化为:
			//
			// dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
			// dp[i][1] = max(dp[i-1][1], -prices[i])
			//
			// 最后我们要在 dp[n-1][0] 的时候返回值，即最后一天不持有股票的时候
			/*int n = prices.length;
			if (n == 0) return 0;
			int[][] dp = new int[n][2];
			for (int i = 0; i < n; i++) {
				// 对base case进行处理
				if (i - 1 == -1) {
					// 第一天就卖出
//					dp[i][0] = Math.max(0, -infinity + prices[i])
					dp[i][0] = 0;
					// dp[i][1] = Math.max(dp[i-1][1], -prices[i])=max(-infinity, -prices[i]);
					// 第一天就买入
					dp[i][1] = -prices[i];
					continue;
				}
				dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
				dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
			}

			return dp[n-1][0];*/

			// 上面的方程可以进行优化为空间复杂度为O（1）的方法
			int n = prices.length;
			if (n == 0) return 0;
			// dp[i][0] = Math.max(0, -infinity + prices[i])
			// dp[i][1] = Math.max(dp[i-1][1], -prices[i])=max(-infinity, -prices[i]);
			int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
				dp_i_1 = Math.max(dp_i_1, -prices[i]);
			}

			return dp_i_0;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}