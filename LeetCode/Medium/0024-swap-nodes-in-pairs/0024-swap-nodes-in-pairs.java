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
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode();

        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = head != null ? head.next : null;

        while(fast != null) {
            ListNode slowTemp = slow.next;
            ListNode fastTemp = fast.next;

            slow.next = fast;
            fast.next = slowTemp;
            slowTemp.next = fastTemp;

            slow = slowTemp;
            if (fastTemp == null) break;
            fast = fastTemp.next;

        }

        return dummy.next;
    }
}