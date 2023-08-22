package top.totalo.leetcode.towpointers;

/**
 * 双指针做法
 * <a href="https://leetcode.cn/problems/trapping-rain-water/">42. 接雨水</a>
 */
public class Leetcode_42 {
    
    // 两个数组的做法，通过判断 i 位置的 前缀和后缀的最大值
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static int trap_1(int[] height) {
        int len = height.length;
        // 前缀最大值
        int[] pre_max = new int[len];
        // 后缀最大值
        int[] suf_max = new int[len];
        pre_max[0] = height[0];
        suf_max[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            pre_max[i] = Math.max(pre_max[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            suf_max[i] = Math.max(suf_max[i + 1], height[i]);
        }
        int ans = 0;
        // i 位置能接的雨水即为 i 位置的前缀和后缀的小的那一个决定，减去他的高度
        for (int i = 0; i < len; i++) {
            ans += Math.min(pre_max[i], suf_max[i]) - height[i];
        }
        return ans;
    }
    
    // 双指针做法，根据性质，统计左右的两边的前缀大小，
    public static int trap_2(int[] height) {
        int len = height.length, pre_max = height[0], suf_max = height[len - 1];
        int left = 1, right = len - 2, ans = 0;
        while (left <= right) {
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);
            if (pre_max > suf_max) {
                ans += suf_max - height[right];
                right--;
            } else {
                ans += pre_max - height[left];
                left++;
            }
            
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(trap_1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(trap_2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
