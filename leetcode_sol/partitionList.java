/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode small = null;
        ListNode large = null;
        
        ListNode p1 = null;
        ListNode p2 = null;
        while (head!= null) {
            if (head.val < x) {
                if (small == null) {
                    small = new ListNode(head.val);
                    p1 = small;
                } else {
                    small.next = new ListNode(head.val);
                    small = small.next;
                } 
            } else {
                if (large == null) {
                    large = new ListNode(head.val);
                    p2 = large;
                } else {
                    large.next = new ListNode(head.val);
                    large = large.next;
                    
                } 
            }  
            head = head.next;
        }
        
        if (p1 == null)
            return p2;
        small.next = p2;
        return p1;
    }
}
