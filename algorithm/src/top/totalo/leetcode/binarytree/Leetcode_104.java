package top.totalo.leetcode.binarytree;

import top.totalo.common.TreeNode;

/**
 * 递归法
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 */
public class Leetcode_104 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(n) 递归会存储上一次的结果
    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
