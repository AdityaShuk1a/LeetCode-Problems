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
            temp = n.next;
        }   

        temp = head;
        while(temp != null){
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;

        }
        temp = head;
        Node newHead = head.next;
        Node copy = newHead;

        while (temp != null) {
            temp.next = copy.next;
            temp = temp.next;
            if (temp != null) {
                copy.next = temp.next;
                copy = copy.next;
            }
        }

        return newHead;
    }
}