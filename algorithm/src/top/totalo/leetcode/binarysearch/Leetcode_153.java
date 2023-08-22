package top.totalo.leetcode.binarysearch;

/**
 * 二分查找
 * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/">153. 寻找旋转排序数组中的最小值</a>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Leetcode_153 {
    
    // 二分查找
    // 时间o(logn)
    // 旋转数组依然有序
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            // 若二分值小于右边的值，说明最小值在[left, mid]，否则说明最小值在[mid + 1, r]
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
    
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2})); // 1
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2})); // 0
        System.out.println(findMin(new int[]{11,13,15,17})); // 11
    }
}
