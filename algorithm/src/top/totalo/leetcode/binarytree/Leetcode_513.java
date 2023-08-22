package top.totalo.leetcode.binarytree;

import top.totalo.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/description/">513. 找树左下角的值</a>
 * <p> 
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 */
public class Leetcode_513 {
    
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    // 思路：最最底层最左边的节点，就是最后一个入队的节点，所以我们可以用层序遍历，最后一个入队的节点就是我们要找的节点
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        assert node != null;
        return node.val;
    }
}
