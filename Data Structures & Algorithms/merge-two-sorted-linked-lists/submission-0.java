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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(0);
        ListNode ans = list;
        while(list1 != null && list2 != null){
            int l1 = list1.val;
            int l2 = list2.val;
            if(l1 <= l2){
                ans.next = new ListNode(l1);
                list1 = list1.next;
            }else{
                ans.next = new ListNode(l2);
                list2 = list2.next;
            }
            ans = ans.next;
        }
        if(list1 != null){
            ans.next = list1;
        }
        if(list2 != null){
            ans.next = list2;
        }

        return list.next;
    }
}