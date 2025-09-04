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

    public int size(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }

        return len;
    }

    public ListNode insertIntoHead(ListNode head, int val){
        ListNode n = new ListNode(val);
        if(head == null){
            head = n;
            return head;
        }
        n.next = head;
        head = n;
        return head;

    }
    public ListNode insertIntoTail(ListNode head, ListNode tail, int val){
        ListNode n = new ListNode(val);
        if(head == null){
            head = n;
            tail = head;
            return head;
        }
        tail.next = n;
        tail = n;
        return tail;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int n = size(head);
        if( n == 0) return head;
        else{

            k = k % n;
        }
        ListNode temp =  head;
        for(int i = 0; i < n - k; i++){
            temp = temp.next;
        }
        ListNode ans = null;
        ListNode tail = null;
        for(int i = n-k; i < n; i++){
            if(ans == null){
                ans = new ListNode(temp.val);
                tail = ans;
            }else{

                tail = insertIntoTail(ans, tail, temp.val);
            }
            temp = temp.next;
        }
        for(int i = 0; i < n - k ; i++){
            if(ans == null){
                ans = new ListNode(head.val);
                tail = ans;
            }else{

                tail = insertIntoTail(ans, tail, head.val);
            }
            head = head.next;

        }
        

        return ans;


    }
}