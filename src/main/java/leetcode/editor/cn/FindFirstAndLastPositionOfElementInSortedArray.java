// 34-在排序数组中查找元素的第一个和最后一个位置

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 939 👎 0


package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = solution.searchRange(nums, 8);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if(len <= 0) {
                return new int[]{-1, -1};
            }

            int first = findFirstPosition(nums, target);
            // 如果连第一个值都没有找到，就直接返回错误
            if(first < 0) {
                return new int[]{-1, -1};
            }

            int last = findLastPosition(nums, target);
            return new int[]{first,last};
        }

        public int findLastPosition(int[] nums, int target) {
            int left, right, mid = 0;
            left = 0;
            right = nums.length - 1;
            System.out.println("Print in findLastPosition func......");
            while(left < right) {
                mid = (left + right + 1) / 2;
                // 调整左边界 (mid, right]
                if(target > nums[mid]) {
                    left = mid + 1;
                } else if(target == nums[mid]) {//[left, mid]
                    left = mid;
                } else {//调整右边界 [left, mid-1]
                    right = mid - 1;
                }
                System.out.println("left = "+left+", right = " + right + ", mid = " + mid);
            }
            return left;
        }

        public int findFirstPosition(int[] nums, int target) {
            int left, right, mid = 0;
            left = 0;
            right = nums.length - 1;
            System.out.println("Print in findFirstPosition func......");
            while(left < right) {
                mid = (left + right) / 2;
                // 调整左边界 (mid, right]
                if(target > nums[mid]) {
                    left = mid + 1;
                } else if(target == nums[mid]) {//[left, mid]
                    right = mid;
                } else {//调整右边界 [left, mid-1]
                    right = mid - 1;
                }
                System.out.println("left = "+left+", right = " + right + ", mid = " + mid);
            }
            if(target == nums[left]) {
                return left;
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}