package top.totalo.leetcode.binarytree;

import top.totalo.common.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">98. 验证二叉搜索树</a>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Leetcode_98 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode root, long lower, long high) {
        if (null == root) {
            return true;
        }
        if (root.val <= lower || root.val >= high) {
            return false;
        }
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, high);
    }
}
