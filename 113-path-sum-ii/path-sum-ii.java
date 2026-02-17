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
    List<List<Integer>> ans = new ArrayList<>();

    public void check(TreeNode node, int target, ArrayList<Integer> temp){
        if(node == null) return;

        temp.add(node.val);

        if(node.left == null && node.right == null && target - node.val == 0){
            ans.add(new ArrayList<>(temp));
        }else{
            check(node.left, target - node.val, temp);
            check(node.right, target - node.val, temp);

        }

        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return ans;
        check(root, target, new ArrayList<>());
        return ans;
    }
}