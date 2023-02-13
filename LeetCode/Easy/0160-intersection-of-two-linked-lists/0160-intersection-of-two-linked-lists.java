/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        Set<ListNode> s = new HashSet<>();

        while(true) {
            s.add(headA);
            if (headA.next == null) {
                break;
            } else {
                headA = headA.next;
            }
        }

        while(true) {
            if (s.contains(headB)) {
                return headB;
            } else if (headB.next != null) {
                headB = headB.next;
            } else {
                break;
            }
        }


        return null;
    }
}