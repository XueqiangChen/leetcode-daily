package leetcode.editor.en;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<nums.length;i++){
                int tmp = target - nums[i];
                if(map.containsKey(tmp)){
                    return new int[]{map.get(tmp),i};   //存在即返回
                }
                map.put(nums[i],i);  //不存在，则加入
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}