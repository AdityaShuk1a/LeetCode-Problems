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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node: lists){
            if(node != null) heap.add(node);
        }

        ListNode ans = new ListNode();
        ListNode temp = ans;

        while(!heap.isEmpty()){
            ListNode curr = heap.poll();
            temp.next = curr;
            temp = temp.next;
            if(curr.next != null){
                heap.add(curr.next);
            }
        }

        return ans.next;

        
    }
}