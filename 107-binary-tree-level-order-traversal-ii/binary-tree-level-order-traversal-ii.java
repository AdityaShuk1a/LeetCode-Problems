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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int child = 2;
        int leaf = 0;
        List<Integer> row = new ArrayList<>();
        row.add(root.val);
        ans.add(row);
        row = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left != null){
                leaf++;
                row.add(node.left.val);
                q.add(node.left);
            }
            
            if(node.right != null){
                leaf++;
                row.add(node.right.val);
                q.add(node.right);
            }

            child -= 2;

            if(child == 0){
                child = leaf * 2;
                leaf = 0;
                if(row.size() > 0){
                    ans.add(row);
                    row = new ArrayList<>();
                }

            }
        }

        Collections.reverse(ans);

        return ans;
    }
}