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
    public ListNode removeElements(ListNode node, int val) {

        if (node == null) return node;

        // 시작 항목이 같은 경우를 먼저 처리 (끝까지 탐색)
        // 처음 시작점이 같지않은 수로 고정되어야 함
        ListNode start = node;
        ListNode next = node.next;
        while(true) {
            if (start != null && start.val == val) {

                start = next;

                if (next != null) next = next.next;

            } else {
                node = start;
                break;
            }
        }

        if (node == null) return node;

        remove(node, node.next, val);
        
        return node;
        
    }

    public void remove(ListNode head, ListNode node, int val) {

        if (node != null && node.val == val) {            
            if (node.next != null) {
                head.next = node.next;
                remove(head, head.next, val);
                return;
            } else {
                head.next = null;
            }
        }

        if (node != null && node.next != null) remove(node, node.next, val);

    }

}