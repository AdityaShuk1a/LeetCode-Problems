/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node temp = head;

        while(temp != null){
            Node n = new Node(temp.val);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node ans = head.next;
        temp = ans;
        Node original = head;
        Node copy = ans;
        while(copy != null){
            // Node next = original.next;
            original.next = original.next.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            copy = copy.next;
            original = original.next;
        }
        return ans;

    }
}