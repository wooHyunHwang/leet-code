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
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) return head;

        ListNode ans = new ListNode();          // 정답 리스트
        ListNode smallStack = new ListNode();   // 작은값 스택
        ListNode bigStack = new ListNode();     // 큰값 스택

        ans.next = head;

        ListNode temp = ans.next;
        ListNode lastSmall = null;
        ListNode lastBig = null;

        while(temp != null) {

            if (temp.val < x) {
                if (smallStack.next == null) smallStack.next = temp;
                if (lastSmall != null) lastSmall.next = temp;
                lastSmall = temp;
            } else {
                if (bigStack.next == null) bigStack.next = temp;
                if (lastBig != null) lastBig.next = temp;
                lastBig = temp;
            }

            temp = temp.next;
        }

        if (smallStack.next != null) {
            ans.next = smallStack.next;
            lastSmall.next = bigStack.next;
            if (lastBig != null) lastBig.next = null;
        } else if (bigStack.next != null) {
            ans.next = bigStack.next;
            lastBig.next = null;
        }

        return ans.next;
    }
}