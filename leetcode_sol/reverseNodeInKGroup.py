class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        def reverse(head: ListNode, tail: ListNode):
            prev = tail.next
            p = head
            while prev != tail:
                nex = p.next
                p.next = prev
                prev = p
                p = nex
            return tail, head
    
        dummy = ListNode(0)
        dummy.next = head
        pre = dummy
        while head:
            tail = pre
            for i in range(k):
                tail = tail.next
                if not tail:
                    return dummy.next
            nex = tail.next
            head, tail = reverse(head, tail)
            pre.next = head
            tail.next = nex
            pre = tail
            head = tail.next
        return dummy.next