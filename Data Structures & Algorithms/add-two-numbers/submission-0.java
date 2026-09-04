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
    public ListNode addTwoNumbers(ListNode r1, ListNode r2) {
        ListNode ans = new ListNode(0);
        ListNode current = ans;
        int carry = 0;

        while(r2 != null && r1 != null){
            int digit = r1.val + r2.val + carry;
            carry = 0;
            if(digit >= 10){ 
                carry = digit / 10;
                digit %= 10;
            }
            current.next = new ListNode(digit);
            current = current.next;
            r1 = r1.next;
            r2 = r2.next;
        }

        while(r1 != null){
            int digit = r1.val + carry;
            carry = 0;
            if(digit >= 10){
                carry = digit / 10;
                digit %= 10;
            }
            current.next = new ListNode(digit);
            r1 = r1.next;
            current = current.next;
        }

        while(r2 != null){
            int digit = r2.val + carry;
            carry = 0;
            if(digit >= 10){
                carry = digit / 10;
                digit %= 10;
            }
            current.next = new ListNode(digit);
            r2 = r2.next;
            current = current.next;
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }

        return ans.next;

    }
}