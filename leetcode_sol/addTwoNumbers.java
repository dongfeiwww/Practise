/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res.next;
        boolean first = true;
        int carry = 0;

        while (l1 != null && l2 != null) {
            res.next = new ListNode((l1.val + l2.val + carry)%10 );
            carry = (l1.val + l2.val + carry)/10;
            
            if (first) {
                head = res;
                first = false;
            }
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        
        while (l1 != null ) {
            res.next = new ListNode((l1.val + carry)%10);
            carry = (l1.val + carry)/10;
            l1 = l1.next;
            res = res.next;
        }
        
       while (l2 != null ) {
            res.next = new ListNode((l2.val + carry)%10);
            carry = (l2.val + carry)/10;
            l2 = l2.next;
            res = res.next;
        }
        
        if (carry != 0) {
            res.next = new ListNode(1);
        }
        
        return head.next;
    }
}
