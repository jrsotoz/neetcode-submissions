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
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(ListNode l : lists){
            while(l != null){
                heap.add(l.val);
                l = l.next;
            }
        }

        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while(!heap.isEmpty()){
            temp.next = new ListNode(heap.poll());
            temp = temp.next;
        }

        return ans.next;
    }
}
