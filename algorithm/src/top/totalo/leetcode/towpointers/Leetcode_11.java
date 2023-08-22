package top.totalo.leetcode.towpointers;

/**
 * 相向双指针
 * <a href="https://leetcode.cn/problems/container-with-most-water/">11. 盛最多水的容器</a>
 */
public class Leetcode_11 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            int x = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(x, ans);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[]{1,1})); // 1
    }
}
