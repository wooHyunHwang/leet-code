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
    public ListNode deleteDuplicates(ListNode head) {
        boolean[] set = new boolean[201];
        ListNode result = new ListNode();
        result.next = head;

        boolean find = false;
        ListNode slow = result;
        ListNode fast = result.next;

        while(fast != null) {
            // System.out.println(fast.val);
            if (set[fast.val + 100]) {
                fast = fast.next;
            } else {
                if (find) {
                    slow.next = fast;
                    find = false;
                }

                set[fast.val + 100] = true;
                find = fast.val == (fast.next != null ? fast.next.val : -101);
                if (!find) slow = slow.next;
                fast = fast.next;
            }
        }

        if (find) {
            slow.next = null;
        }


        return result.next;
    }
}