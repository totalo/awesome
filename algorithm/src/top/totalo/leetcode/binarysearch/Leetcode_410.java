package top.totalo.leetcode.binarysearch;

/**
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 */
public class Leetcode_410 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitArray(new int[]{7,2,5,10,8}, 2)); // 18
        System.out.println(solution.splitArray(new int[]{1,2,3,4,5}, 2)); // 9
        System.out.println(solution.splitArray(new int[]{1,4,4}, 3)); // 4
    }
    
    
    static class Solution {
        public int splitArray(int[] nums, int k) {
            int l = 0, r = 0;
            // 确定左右边界
            for (int i = 0; i < nums.length; i++) {
                r += nums[i];
                if (l < nums[i]) {
                    l = nums[i];
                }
            }
            
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                // 如果满足条件数，说明 当前的区间数还是小于题目的区间数，则可以进一步缩小和的大小，增加区间数
                // 否则说明，和的数已经不满足区间数，需要进一步缩小区间
                if (check(nums, mid, k)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
        
        private boolean check(int[] nums, int x, int m) {
            int sum = 0, cnt = 1;
            for (int i = 0; i < nums.length; i++) {
                // 若当前值加上sum大于扫描的值，则统计区间数，否则添加
                if (sum + nums[i] > x) {
                    cnt++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            // 判断区间数是否满足要求
            return cnt <= m;
        }
    }
    
}
