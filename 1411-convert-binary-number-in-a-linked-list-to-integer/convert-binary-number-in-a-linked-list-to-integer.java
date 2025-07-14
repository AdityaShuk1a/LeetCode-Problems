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
    public int getDecimalValue(ListNode head) {
        int i = 0;
        int ans = 0;
        while(head != null){
            // ans += ((int) head.val * (long) Math.pow(2, i)) ;
            // i++;
            // System.out.print(i + " ");
            ans = ans << 1 | head.val;
            head = head.next;
        }

        return ans;
    }
}