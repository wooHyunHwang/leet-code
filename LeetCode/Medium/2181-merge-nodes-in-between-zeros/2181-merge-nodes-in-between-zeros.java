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
    public ListNode mergeNodes(ListNode node) {
        ListNode dummy = new ListNode();
        ListNode zero = node;
        int sum = 0;
        dummy.next = node;

        node = node.next;
        while(node != null) {
            if (node.val == 0) {
                zero.val = sum;
                if (node.next == null) zero.next = null;
                else zero.next = node;
                zero = node;
                sum = 0;
            }
            else {
                sum += node.val;
            }
            node = node.next;
        }

        return dummy.next;
    }
}