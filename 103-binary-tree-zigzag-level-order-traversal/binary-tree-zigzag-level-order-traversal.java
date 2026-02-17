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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        int level = 1;
        if(root == null) return ans;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> row = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node;
                node = q.poll();
                
                row.add(node.val);

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                   q.add(node.right);
                }
            }
            ans.add(row);
        }
        for(List<Integer> i: ans){
            if(level % 2 == 0){
                Collections.reverse(i);
            }
            level++;
        }

        return ans;
    }
}