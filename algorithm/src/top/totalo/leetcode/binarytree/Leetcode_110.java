package top.totalo.leetcode.binarytree;

import top.totalo.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Leetcode_110 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public static boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height != -1;
    }
    
    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左子树的高度，若左子树的高度不满足，则返回-1
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        
        // 计算左右子树的差值，若差值超过1，则说明不满足条件，返回-1
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // todo 测试用例
}
