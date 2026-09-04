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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ListNode current = ans;

        while(head != null){
            ListNode temp = new ListNode(0);
            ListNode c = temp;
            int size = 0;
            for(int i = 0 ; i < k && head != null ; i++){
                c.next = new ListNode(head.val);
                size++; 
                c = c.next;
                head = head.next;
            }
            if(size == k){
                ListNode t = revertListNode(temp.next);
                while(t != null){
                    current.next = t;
                    t = t.next;
                    current = current.next;
                }
            }else{
                current.next = temp.next;
            }
        }

        return ans.next;
    }

    public ListNode revertListNode(ListNode head){
        ListNode current = null;

        while(head != null){
            ListNode temp = head.next;
            head.next = current;
            current = head;
            head = temp;
        }

        return current;
    }
}