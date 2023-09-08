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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        
        int index = 1;
        boolean find = false;
        ListNode cur = head;
        ListNode start = null;
        ListNode startBefore = null;
        ListNode before = null;

        ListNode reverse = null;

        while(cur != null) {
            ListNode next = cur.next;

            if (find) {
                // 대상 찾아서 뒤집기 진행중
                // System.out.println(cur.val + "<==" + before.val);
                cur.next = before;
                if(index == right) {
                    if (startBefore != null) startBefore.next = cur;
                    else head = cur;
                    start.next = next;
                    break;
                }

            } else {
                // 대상 찾는중...
                if (index == left) {
                    // 찾음
                    find = true;
                    start = cur;
                    startBefore = before;
                }
            }
            before = cur;
            cur = next;
            index++;
        }

        return head;
    }
}