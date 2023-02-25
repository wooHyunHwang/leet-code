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
    ListNode ans = null;
    public ListNode reverseList(ListNode node) {

        if(node == null) return node;

        recursive(node);

        return ans;

    }


    public ListNode recursive(ListNode node) {
        if(node.next != null) {
            ListNode expose = recursive(node.next);
            expose.next = new ListNode(node.val);
            return expose.next;
        } else {
            ans = new ListNode(node.val);
            return ans;
        }
    }
}