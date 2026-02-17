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
    int maxLength = 0;
    public int check(TreeNode node){
        if(node == null) return 0;

        int left = check(node.left);
        int right = check(node.right);

        maxLength = Math.max(maxLength, 1 + left + right);

        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int x = check(root);

        return maxLength - 1;
    }
}