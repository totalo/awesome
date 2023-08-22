package top.totalo.leetcode.binarysearch;

/**
 * 题目链接：<a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">33. 搜索旋转排序数组</a>
 *整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Leetcode_33 {
    
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(search(new int[]{1}, 0)); // -1
    }
    
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                return mid;
                // 如果中间值 右边的最大值大，需要在下一个端点查找
            }
            if (nums[mid] > nums[r]) {
                // 中间节点比结果值大,结果值比左端点大，说明区间为[l, mid]
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    // 否则说明区间为[mid, l]
                    l = mid + 1;
                }
            } else {
                // 中间值比右边的值小。且中间值小于所需要的值，结果值也小于右边最大值说明需要更新到[mid+ 1 ]
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
