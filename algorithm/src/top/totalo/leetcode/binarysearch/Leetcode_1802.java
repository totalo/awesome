package top.totalo.leetcode.binarysearch;

/**
 * 1802. 有界数组中指定下标处的最大值
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 *
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 *
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 */
public class Leetcode_1802 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue(4, 2, 6));
        System.out.println(solution.maxValue(6, 1, 10));
    }
    
    static class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int l  = 1, r = maxSum;
            while (l < r) {
                int mid = ((r - l + 1) >> 1) + l;
                if (check(mid, n, index, maxSum)) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
        
        private boolean check(int mid, int n, int idx, int maxSum) {
            int r = n - idx - 1;
            return mid + sum(mid, idx) + sum(mid, r) <= maxSum;
        }
        
        private long sum(int big, int length) {
            if (length + 1 < big) {
                int s = big - length;
                return (long) (big - 1 + s) * length / 2;
            } else {
                int o = length - (big - 1);
                return (long) big * (big - 1) / 2 + o;
            }
        }
    }
}
