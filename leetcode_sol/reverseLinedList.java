/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == n)
            return head;
        
        ListNode start = head;
        int i = m-1;
        ListNode prev = null;
        while (i>0) {
            prev = start;
            start = start.next;
            i--;
        }
        
        int delta = n - m +1;
        ListNode p = null;
        ListNode cur = start;
        ListNode next = null;
        while (delta >0) {
            next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
            delta--;
        }
        
        if (prev!=null)
            prev.next = p;
        
        if (next != null)
            start.next = next;
            
        if (m == 1)
            return p;
        return head;
    }
}
