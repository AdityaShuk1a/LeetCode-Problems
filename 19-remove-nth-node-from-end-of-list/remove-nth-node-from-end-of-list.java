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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode temp = head;

        while(temp != null){
            k++;
            temp = temp.next;
        }
        

        int i = 0;
        temp = head;
        n = k - n;
        if(n == 0){
            head = head.next;
            return head;
        }
        while(temp.next != null){
            i++;
            if(i == n){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;

        }

        return head;
    }
}