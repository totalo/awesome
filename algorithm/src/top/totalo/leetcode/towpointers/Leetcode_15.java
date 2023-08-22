package top.totalo.leetcode.towpointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 相向双指正
 * <a href="https://leetcode.cn/problems/3sum/">15. 三数之和</a>
 */
public class Leetcode_15 {
    
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, i = 0;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while (i < len - 2) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                i++;
                continue;
            }
            // 如果最小值已经大于0了，那么后续没必要遍历了
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            
            // 如果加上最大值小于0，说明x过于小，需要右移动
            if (x + nums[len - 1] + nums[len - 2] < 0) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4})); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(threeSum(new int[]{0,1,1})); // []
        System.out.println(threeSum(new int[]{0,0,0})); // [[0, 0, 0]]
    }
}
