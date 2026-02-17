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
    public int check(TreeNode node){
        if(node == null) return 0;

        int left = check(node.left);
        int right = check(node.right);

        int maxx = 1 + Math.max(left, right);

        return maxx;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return check(root);
    }
}