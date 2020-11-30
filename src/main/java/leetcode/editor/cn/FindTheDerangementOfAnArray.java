package leetcode.editor.cn;

/**
 * 在组合数学中，如果一个排列中所有元素都不在原先的位置上，那么这个排列就被称为错位排列。
 *
 * 给定一个从 1 到 n 升序排列的数组，你可以计算出总共有多少个不同的错位排列吗？
 *
 * 由于答案可能非常大，你只需要将答案对 (10^9)+7 取余输出即可。
 *
 * 样例 1:
 * 输入: 3
 * 输出: 2
 * 解释: 原始的数组为 [1,2,3]。
 * 两个错位排列的数组为 [2,3,1] 和 [3,1,2]。
 *
 * 注释:
 * n 的范围是 [1, 106]。
 * 此问题跟信件错排问题是一样的：有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。
 *
 * 解题思路：
 * D_(n)=n * D_(n-1) + (-1)^n
 * https://zh.wikipedia.org/wiki/%E9%94%99%E6%8E%92%E9%97%AE%E9%A2%98
 * https://www.cnblogs.com/grandyang/p/7210929.html
 */
public class FindTheDerangementOfAnArray {
	public static void main(String[] args) {
		FindTheDerangementOfAnArray.Solution solution = new FindTheDerangementOfAnArray().new Solution();
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(solution.findDerangement(nums));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public long findDerangement(int[] nums) {
			// 数组的长度为0或1的时候，dp[0] = 0, dp[1] = 0;
			// 数组中有两个数的时候， dp[2] = 1
			// 数组长度 n>=3 的时候，假设第 n 个位置与第 k 个位置对换，这里先假设 k=3, n=4
			// 当 n 和 k 对调的时候，即
			// x x 4 3
			// 3 和 4 的位置已经固定，就是求前面 n-2 的错排情况，即 dp[n-2]，由于 k 的取值为 1<=k<=n-1, k有n-1种可能，所以这种
			// 情况下的全部可能为 (n-1)*dp[n-2]
			// 当 k 的位置不在 n 的时候，那么将第n位重新考虑成一个新的“第k位”，这时的包括k在内的剩下n-1个数的每一种错排，
			// 都等价于只有n-1个数时的错排（只是其中的第k位会换成第n位）。其错排数为 dp[n-1], 同样，k的取值有n-1种可能，所以这种
			// 情况下的全部可能为 (n-1)*dp[n-2]
			// x x x
			// 总结上述两种情况，得到递推公式：dp[n]=(n-1)*(dp[n-1]+dp[n-2])

			/*if (nums.length < 2) {
				return 0;
			}

			int len = nums.length;
			int[] dp = new int[len + 1];
			dp[1] = 0;
			dp[2] = 1;
			for (int i = 3; i <= len; i++) {
				dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2]))*//* % (1000000007)*//*;
			}

			return dp[len];*/

			// 因为上面的动态规划只跟两个值有关，我们优化一下算法
			if (nums.length < 2) {
				return 0;
			}

			int first = 0;
			int second = 1;
			for (int i = 3; i <= nums.length; i++) {
				int temp = second;
				second = ((i - 1) * (second + first)) % 1000000007;
				first = temp;
			}

			return second;
		}
	}
}
