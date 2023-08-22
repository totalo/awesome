package top.totalo.leetcode.binarytree;

import top.totalo.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description/">199. 二叉树的右视图</a>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Leetcode_199 {
    static List<Integer> ans;
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public static List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<Integer>();
        rightSideView(root, 0);
        return ans;
    }
    
    public static void rightSideView(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        rightSideView(node.right, depth + 1);
        rightSideView(node.left, depth + 1);
    }
}
