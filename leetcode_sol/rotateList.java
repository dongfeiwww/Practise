/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        if (n == 0)
            return head;
        if (head == null || head.next == null)
            return head;
            
        ListNode p = head;
        
        int lean = 0 ;
        while (p!=null) {
            len++;
            p=p.next;
        }
        
        if (n%len == 0)
            return head;
            
        p=head;
        while (i < n%len) {
            p = p.next;
            i++;
        }

        ListNode prev = null;
        ListNode tail = null;
        ListNode start = head;
        while (p!= null) {
            tail = p;
            p = p.next;
            prev = start;
            start = start.next;
        }
        

        prev.next = null;
        tail.next = head;
        return start;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        ListNode cur=head;
        int len=1;
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        cur.next=head;
        int preLen=len-n%len-1;
        ListNode pre=head;
        while(preLen>0){
            pre=pre.next;
            preLen--;
        }
        head=pre.next;
        pre.next=null;
        return head;
    }
}
