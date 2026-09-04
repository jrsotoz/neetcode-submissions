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
        ListNode temp = head;
        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        temp = sentinel;

        for(int i = 0 ; i < size && temp != null; i++){
            if(size - i == n){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return sentinel.next;
    }
}