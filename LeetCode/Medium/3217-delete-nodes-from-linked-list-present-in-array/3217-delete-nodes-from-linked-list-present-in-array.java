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
    public ListNode modifiedList(int[] nums, ListNode node) {
        ListNode dummy = new ListNode();
        boolean[] set = new boolean[100_001];

        for (int n : nums) set[n] = true;

        dummy.next = node;
        ListNode linked = dummy;

        while (node != null) {

            if (!set[node.val]) {
                linked.next = node;
                linked = linked.next;
            }

            node = node.next;
        }

        linked.next = null;

        return dummy.next;
    }
}