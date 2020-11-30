//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，
//这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻
//的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//    偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 426 👎 0


package leetcode.editor.cn;

public class HouseRobberIi {
	public static void main(String[] args) {
		Solution solution = new HouseRobberIi().new Solution();
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
		System.out.println(solution.rob(nums));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int rob(int[] nums) {
			if (nums == null || nums.length == 0) {
				return 0;
			}

			int length = nums.length;
			if (length == 1) {
				return nums[0];
			}

			// 分成两个数组做，即偷第一家和不偷第一家的情况
			return Math.max(robRange(nums, 0, length-2), robRange(nums, 1, length-1));
		}

		private int robRange(int[] nums, int start, int end) {
			int len = nums.length - 1;
			if (len == 1) {
				return nums[start];
			}

			// 这里可以优化成滚动数组
			/*int[] dp = new int[end + 1];
			dp[start] = nums[start];
			dp[start+1] = Math.max(nums[start], nums[start+1]);
			for (int i = start + 2; i < end + 1; i++) {
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			}

			return dp[end];*/

			int first = nums[start];
			int second = Math.max(nums[start], nums[start + 1]);
			for (int i = start + 2; i < end + 1; i++) {
				int temp = second;
				second = Math.max(first + nums[i], second);
				first = temp;
			}

			return second;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}