public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast, slow;
        fast = slow = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}

// def find_cycle_length(head):
//   slow, fast = head, head
//   while fast is not None and fast.next is not None:
//     fast = fast.next.next
//     slow = slow.next
//     if slow == fast:  # found the cycle
//       return calculate_cycle_length(slow)

//   return 0


// def calculate_cycle_length(slow):
//   current = slow
//   cycle_length = 0
//   while True:
//     current = current.next
//     cycle_length += 1
//     if current == slow:
//       break
//   return cycle_length
