package top.totalo.template;

import top.totalo.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的广度优先遍历、层次遍历
 * 
 */
public class TreeNodeBFS {
    
    public static void bfs(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前层,当前队列的大小即为当前层的节点数
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer((cur.right));
                }
                // do something for cur node
            }
        }
    }
}
