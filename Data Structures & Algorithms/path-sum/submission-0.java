/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return found(root, targetSum, 0);
    }
    private boolean found(TreeNode n, int t, int s) {
        if (n == null)
            return t == s;
        if (n.left == null && n.right == null)
            return t == n.val + s;
        boolean res = false;
        if (n.left != null)
            res = found(n.left, t, s + n.val);
        if (res)
            return true;
        if (n.right != null)
            res |= found(n.right, t, s + n.val);
        return res;
    }
}