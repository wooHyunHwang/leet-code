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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) return head;

        ListNode result = new ListNode();
        result.next = head;

        int length = 1;
        ListNode process = result.next;
        ListNode last = null;

        // 마지막을 구함
        while (process != null) {
            if (process.next == null) last = process;
            else length++;
            process = process.next;
        }

        // System.out.println("len : " + length);

        // 마지막을 처음과 연결해서 순회 구조로
        last.next = result.next;

        int reply = length - k % length - 1;
        process = result.next;

        // System.out.println("실제 전진 : " + reply);

        for (int i = 0; i < reply; ++i) {
            process = process.next;
        }

        result.next = process.next;
        process.next = null;


        return result.next;
    }
}