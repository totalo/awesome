package top.totalo.leetcode.binarytree;

import top.totalo.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/">101. 对称二叉树</a>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Leetcode_101 {
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    
    private static boolean check(TreeNode u, TreeNode v) {
        if (u == null && v == null) {
            return true;
        }
        if (u == null || v == null) {
            return false;
        }
        return v.val == u.val && check(u.left, v.right) && check(u.right, v.left);
    }
}
