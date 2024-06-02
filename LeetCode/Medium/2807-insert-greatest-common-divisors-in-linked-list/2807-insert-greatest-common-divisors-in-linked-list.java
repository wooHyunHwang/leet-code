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
    public ListNode insertGreatestCommonDivisors(ListNode node) {

        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null) {
            ListNode newNode = new ListNode(
                this.euclideanAlgorithm(slow.val, fast.val)
            );
            slow.next = newNode;
            newNode.next = fast;
            slow = fast;
            fast = fast.next;
        }

        return node;
    }

    private int euclideanAlgorithm(int val1, int val2) {
        int remain = val1 % val2;
        if (remain > 0) {
            return this.euclideanAlgorithm(val2, remain);
        }
        return val2;
    }
}