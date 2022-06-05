/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null)
            return head;
        
        ListNode newNode = head.next;
        ListNode p;
        ListNode cur = head;
        while(head != null && head.next != null) {
            p = head.next.next;
            
            head.next.next = head;
            if (p != null)
                head.next = p.next;
            else 
                head.next = null;
            cur = head;
            head = p;
        }
        
        if (head != null)
            cur.next = head;
        return newNode;
    }
}
