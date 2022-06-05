/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        ListNode pPrePre=null;
        ListNode pPre=null;
        ListNode p=head;
        int key=Integer.MAX_VALUE;
        while(p!=null){
            if(p.val!=key){
                key=p.val;
                pPrePre=pPre;
                pPre=p;
                p=p.next;
            }else{
                if(pPre!=null&&pPre.val==key){
                    ListNode pNext=p.next;
                    if(pPrePre!=null) pPrePre.next=pNext;
                    if(pPre==head) head=pNext;
                    pPre=pPrePre;
                    p=pNext;
                }else{
                    ListNode pNext=p.next;
                    if(pPre!=null) pPre.next=pNext;
                    if(p==head) head=pNext;
                    p=pNext;
                }
            }
        }
        return head;
    }
}
