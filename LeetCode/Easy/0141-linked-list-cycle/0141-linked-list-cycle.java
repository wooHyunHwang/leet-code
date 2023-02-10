/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // 순회가 어디든지 있다면...?
        List<ListNode> list = new ArrayList();

        boolean start = true;
        ListNode next = head;

        while(true) {
            if(!start) {
                if(next == null) {
                    return false;
                } else if (list.contains(next)) {
                    return true;
                }
            } else {
                start = false;
            }
            list.add(next);
            next = next.next != null ? next.next : null;
        }
    }
}