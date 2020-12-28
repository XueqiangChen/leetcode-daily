// leetcode - 303
// 给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
//
// 
// 
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 使用数组 nums 初始化对象 
// int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 s
//um(nums[i], nums[i + 1], ... , nums[j])） 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 0 <= i <= j < nums.length 
// 最多调用 104 次 sumRange 方法 
// 
// 
// 
// Related Topics 动态规划 
// 👍 212 👎 0

  
package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImmutable{
  public static void main(String[] args) {
//       Solution solution = new RangeSumQueryImmutable().new Solution();
	  int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
	  NumArray numArray = new RangeSumQueryImmutable().new NumArray(nums);
	  System.out.println(numArray.sumRange(0, 2));
	  System.out.println(numArray.sumRange(2, 5));
	  System.out.println(numArray.sumRange(0, 5));


  }
  //leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

  	// 方法一：
  	// private int[] nums;

	// 方法二: HashMap 做缓存
//	private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

	// 方法三: 缓存，动态规划
	private int[] sum;

    public NumArray(int[] nums) {
    	// 方法一
		// this.nums = nums;

		// 方法二：构造函数中遍历数组，将每一种 i，j 的和都存入map中，后面无论调用多少次 sumRange 方法
		// 都是从map中取值
		/*for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				map.put(new Pair<>(i, j), sum);
			}
		}*/

		// 方法三：动态规划，第k个位置的累计和，等于k-1个位置的累计和加上当前这个位置的值。那么求i~j这个位置的
		// 累计和，等于 sumRange(i, j) = sum[j+1] - sum[i], 即0-j+1的和减去0~i-1的和
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i+1] = sum[i] + nums[i];
		}
    }
    
    public int sumRange(int i, int j) {
    	// 方法一: 暴力求解
		/*if (nums.length <= 0 || i < 0 || i > nums.length || j < 0 || j > nums.length) {
			return 0;
		}

		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += nums[k];
		}

		return sum;*/

		// 方法二: 缓存
//		return map.get(new Pair<>(i, j));

		// 方法三: 缓存，动态规划
		return sum[j+1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}