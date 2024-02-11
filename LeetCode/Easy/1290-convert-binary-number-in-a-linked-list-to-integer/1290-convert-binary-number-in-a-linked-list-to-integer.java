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
    private int depth = 0;
    public int getDecimalValue(ListNode head) {
        return this.recursive(head, 0, 0);
    }

    private int recursive(ListNode node, int i, int ans) {
        if (node.next != null) {
            depth++;
            ans += this.recursive(node.next, i + 1, ans);
        }

        if (node.val == 1) ans += Math.pow(2, depth - i);

        

        return ans;
    }
}