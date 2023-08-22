package top.totalo.leetcode.binarytree;


import top.totalo.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235. 二叉搜索树的最近公共祖先</a>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Leetcode_235 {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return root;
        }
        int val = root.val;
        if (p.val < val && q.val < val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > val && q.val > val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
