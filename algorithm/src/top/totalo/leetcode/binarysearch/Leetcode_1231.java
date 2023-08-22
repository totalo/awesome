package top.totalo.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。
 *
 * 你打算和 K 名朋友一起分享这块巧克力，所以你需要将切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。
 *
 * 为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。
 *
 * 请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。
 */
public class Leetcode_1231 {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximizeSweetness(new int[]{1,2,3,4,5,6,7,8,9}, 5)); // 6
        System.out.println(solution.maximizeSweetness(new int[]{5,6,7,8,9,1,2,3,4}, 8)); // 1
        System.out.println(solution.maximizeSweetness(new int[]{1,2,2,1,2,2,1,2,2}, 2)); // 5
        System.out.println(solution.maximizeSweetness(new int[]{90670,55382,95298,95795,73204,41464,18675,30104,47442,55307}, 6)); // 55382
    }
    
    /**
     * 二分求解
     */
    static class Solution {
        public int maximizeSweetness(int[] nums, int k) {
            
            // 左边界为 0 或者数组的最小值
            int l = 0;
            // 右边界为甜度的和或者每份的均值，满足条件的一定比
            int r = Arrays.stream(nums).sum() / (k + 1);
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                // 当前甜度满足 k + 1 份，则还可以
                if (check(nums, k + 1, mid)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return r;
        }
        
        private boolean check(final int[] nums, final int k, final int mid) {
            int sum = 0, cnt = 0;
            for (final int num : nums) {
                sum += num;
                // todo 没办法理解，为啥这里可以大于甜度后再进行分割？
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }
            return cnt >= k;
        }
    }
}
