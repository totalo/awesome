package top.totalo.leetcode.dp;

import top.totalo.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/">124. 二叉树中的最大路径和</a>
 * <p>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Leetcode_124 {
    
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, left + right + node.val);
        return Math.max(Math.max(left, right) + node.val, 0);
    }
}
