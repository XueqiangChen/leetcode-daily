//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 764 👎 0


package leetcode.editor.cn;

public class UniquePaths {
	public static void main(String[] args) {
		Solution solution = new UniquePaths().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int uniquePaths(int m, int n) {
			if (m <= 0 || n <= 0) {
				return 0;
			}

			/*//base case
			int[][] dp = new int[m][n];
			// 第一列和第一行的初始值都为1，因为机器人只能向右或者向下行走，第一列和第一行到达的方式都只有一种
			dp[0][0] = 1;
			for (int i = 1; i < m; i++) {
				dp[i][0] = 1;
			}
			for (int j = 1; j < n; j++) {
				dp[0][j] = 1;
			}

			// 除了第一行和第一列只有一种方式外，假设机器人要走到(i,j)这个单元格有dp[i][j]种路径，
			// 那么到达(i,j)的方式有两种，一种是从(i-1,j)，即从上一行走下来，一种是(i,j-1)，即从
			// 上一列向右移动，假设到达(i-1,j)的方法一共有dp[i-1][j]种，到达(i, j-1)的方法有dp[i][j-1]
			// 种，那么到达(i,j)的方式一共有:
			// dp[i][j]=dp[i-1][j]+dp[i][j-1]
			for(int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}

			return dp[m-1][n-1];*/

			// 将上述的二维数据优化为一维数组，我们知道(i,j)这个位置的值只跟上一行的值和(i,j-1)这个位置的值有关，
			// i-2行之前的值都可以不要, 动态转移方程简化为：
			// dp[i] = dp[i-1] + dp[i]
			int[] dp = new int[n];
			for (int i=0; i < n; i++) {
				dp[i] = 1;
			}

			for (int i = 1; i < m; i++) {
				//每一行的第一个元素的值都为1
				dp[0] = 1;
				for (int j = 1; j < n; j++) {
					dp[j] = dp[j-1] + dp[j];
				}
			}

			return dp[n-1];
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}