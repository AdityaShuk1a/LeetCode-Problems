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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int poww = 1;
        int ele = (int)Math.pow(2, poww);
        
        List<Integer> row = new ArrayList<>();
        row.add(root.val);

        ans.add(row);

        row = new ArrayList<>();
        int child = 0;
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left != null){
                child++;
                q.add(node.left);
                row.add(node.left.val);
            }
            if(node.right != null){
                child++;
                q.add(node.right);
                row.add(node.right.val);
            }
            ele -= 2;
            if(ele == 0 && child != 0){
            //    poww++;
               ele = child * 2;
               child = 0;
               ans.add(row);
               row = new ArrayList<>();
            }

        }

        if(row.size() != 0) ans.add(row);
        return ans;
    }
}