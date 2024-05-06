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
    public ListNode removeNodes(ListNode node) {
        ListNode dummy = new ListNode();

        // dummy next is last Top Value
        dummy.next = node;

        // Point descending Node
        Stack<ListNode> descend = new Stack<>();
        descend.add(node);

        while (node != null) {
            // System.out.println(node.val);
            // 최대값 확인
            if (dummy.next.val < node.val) {
                // System.out.println(" ====== 최대값 갱신 " + node.val);
                dummy.next = node;
                descend.clear();
            }
            else {
                // System.out.println(" ====== 비교 " + descend.peek().val);
                if (descend.peek().val < node.val) {
                    while (!descend.isEmpty()) {
                        descend.pop();
                        if (descend.peek().val >= node.val) {
                            descend.peek().next = node;
                            break;
                        }
                    }
                }
            }
            descend.add(node);
            node = node.next;
        }

        return dummy.next;
    }
}

// 5,8,2,3,13,3,8
// 8,2,3,13,3,8
// 8,2,3,13,3,8
// 8,3,13,3,8
// 13,3,8
// 13,3,8
// 13,8