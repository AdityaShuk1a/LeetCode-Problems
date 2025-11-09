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
    public void reorderList(ListNode head) {
        if (head.next != null) {

            ListNode temp = head;
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;
            ListNode newHead = null;
            while (slow != null) {
                ListNode nextt = slow.next;
                slow.next = newHead;
                newHead = slow;
                slow = nextt;
            }

            while (temp.next != null) {
                ListNode curr = temp;
                ListNode curr2 = newHead;

                ListNode nextt = temp.next;
                newHead = newHead.next;
                curr2.next = nextt;
                curr.next = curr2;
                temp = nextt;
            }

            temp.next = newHead;
        }

    }
}