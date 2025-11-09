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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode ans = l1;
        ListNode lastVal = l1;
        int carry = 0;
        while(l1 != null && l2 != null){

            int newVal = l1.val + l2.val + carry;
            carry = newVal / 10;
            System.out.print(newVal%10 + " ");
            

            l1.val = newVal % 10;
            if(l1.next == null) lastVal = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            
            int newVal = l1.val + carry;
            carry = newVal / 10;
            newVal = newVal % 10;
            l1.val = newVal;
            if(l1.next == null) lastVal = l1;
            l1 = l1.next;
        }

        while(l2 != null){

            int newVal = l2.val + carry;
            carry = newVal / 10;
            
            ListNode n = new ListNode(newVal % 10);
            lastVal.next = n;
            lastVal = n;
            l2 = l2.next;
        }

        if(carry != 0){

            ListNode n = new ListNode(carry);
            lastVal.next = n;
        }
        ListNode temp = ans;
        while(temp != null){
            temp = temp.next;
        }
        return ans;

    }
}