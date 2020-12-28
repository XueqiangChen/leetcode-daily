// leetcode-413
//
//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
//
// 例如，以下数列为等差数列: 
//
// 
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 以下数列不是等差数列。 
//
// 
//1, 1, 2, 5, 7 
//
// 
//
// 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。 
//
// 如果满足以下条件，则称子数组(P, Q)为等差数组： 
//
// 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。 
//
// 函数要返回数组 A 中所有为等差数组的子数组个数。 
//
// 
//
// 示例: 
//
// 
//A = [1, 2, 3, 4]
//
//返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
// 
// Related Topics 数学 动态规划 
// 👍 194 👎 0

  
package leetcode.editor.cn;

public class ArithmeticSlices{
  public static void main(String[] args) {
       Solution solution = new ArithmeticSlices().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  	public int numberOfArithmeticSlices(int[] A) {
  		// 动态规划解法
		int[] dp = new int[A.length];
		int sum = 0;
		for (int i=2; i < dp.length; i++) {
			if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
				dp[i] = dp[i-1] + 1;
				sum += dp[i];
			}
		}

		return sum;
	}
    public int numberOfArithmeticSlices1(int[] A) {
		int count = 0;
		// s 从0~leng-2，因为内循环 e 的值为 s+2，所以 s 最多只能到length-2
		for (int s = 0; s < A.length - 2; s++) {
			// 等差的差值
			int d = A[s+1] - A[s];
			// 从s~e 位置求等差数组的个数，每次e+1,直到e到数组的最后一个元素位置，即 s~e 的所有等差数组个数
			for (int e = s + 2; e < A.length; e++) {
				// 优化：如果当前在处理一个区间 (s,e)，其中 A[s]（区间头）和 A[e]（区间尾），
				// 我们需要检查这个区间内所有相邻元素的差值是不是都相等。现在，把这个区间扩大一点，
				// 变成从 s 到 e+1，我们就需要再一次对于区间 s:e 中的所有元素做一遍等差判断，然后
				// 再额外判断 A[e+1] 和 A[e] 的差值是不是跟之前的相等。其实是可以不用重复的判断区间
				// s:e 的，只需要判断最后一对元素的差值是不是跟之前区间中的差值相等就可以了。
				//
				/*int i = 0;
				// 这个循环用来判断 s~e 这个子数组内的相邻元素的差值，确定子数组是否为等差序列
				for (i = s+1; i <= e; i++) {
					if (A[i] - A[i-1] != d) {
						break;
					}
				}

				if (i > e) {
					count++;
				}*/
				if (A[e] - A[e-1] == d) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}