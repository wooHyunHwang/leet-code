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
    public ListNode[] splitListToParts(ListNode node, int k) {
        ListNode[] ans = new ListNode[k];

        int length = 0;

        ListNode temp = node;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        int div = length / k;
        int remain = length % k;

        int i = 0;
        while(node != null) {
            ans[i++] = node;
            ListNode before = node;
            for (int j = 0; j < div && node != null; ++j) {
                before = node;
                node = node.next;
            }
            if (remain > 0 && node != null) {
                remain--;
                before = node;
                node = node.next;
            }
            before.next = null;
        }

        return ans;
    }
}