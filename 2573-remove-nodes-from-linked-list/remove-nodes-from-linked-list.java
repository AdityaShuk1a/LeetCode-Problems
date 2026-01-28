/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        // st.add(head.val);

        ListNode temp = head;

        while(temp!=null){
            if(!st.isEmpty() && ( temp.val > st.peek().val )){
                while(!st.isEmpty() && temp.val > st.peek().val){
                    st.pop();
                }
            }
            st.add(temp);
            temp = temp.next;
        }

        ListNode curr = null;
        while(!st.isEmpty()){
            temp = st.pop();
            temp.next = curr;
            curr = temp;
        }

        return temp;

    }
}