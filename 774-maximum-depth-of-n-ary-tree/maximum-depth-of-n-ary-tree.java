/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxDepth = 0;

    public void traverse(Node root, int depth){
        if(root == null) {
            return;
        }
        List<Node> child = root.children;
        if(child.size() == 0){  
            maxDepth = Math.max(depth, maxDepth);
            return;
        }
        for(Node i: child){
            traverse(i, depth + 1);
        }

    }

    public int maxDepth(Node root) {
        if(root == null) return 0;
        traverse(root, 0);
        return maxDepth + 1;
    }
}