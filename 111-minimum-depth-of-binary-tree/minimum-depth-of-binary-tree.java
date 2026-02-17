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
        if(node.left == null) return right + 1;
        if(node.right == null) return left + 1;

        int min = 1 + Math.min(left, right);

        return min;
    }
    public int minDepth(TreeNode root) {
        // if(root == null) return 0;
        return check(root);
    }
}