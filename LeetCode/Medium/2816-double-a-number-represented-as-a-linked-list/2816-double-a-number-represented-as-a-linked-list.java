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
    public ListNode doubleIt(ListNode node) {
        ListNode dummy = new ListNode(1);
        dummy.next = node;

        boolean flag = false;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while(!stack.isEmpty()) {
            ListNode cur = stack.pop();
            cur.val *= 2;
            if (flag) {
                cur.val++;
                flag = false;
            }
            if (cur.val > 9) {
                flag = true;
                cur.val %= 10;
            }
        }

        return flag ? dummy : dummy.next;
    }
    public ListNode doubleIt2(ListNode node) {
        ListNode dummy = new ListNode();
        dummy.next = node;

        long val = 0;
        long digit = 1;
        while (node != null) {
            val += node.val;
            if (node.next != null) {
                val *= 10;
                digit *= 10;
            }
            node = node.next;
        }

        val *= 2;

        // System.out.println("twice " + val);

        if (val / digit > 9) {
            digit *= 10;
            node = dummy;

            while (node != null) {
                // System.out.println(node.val + " === " + digit);
                node.val = (int) (val / digit);
                val %= digit;
                digit /= 10;
                node = node.next;
            }

            return dummy;
        }
        else {
            node = dummy.next;

            while (node != null) {
                // System.out.println(node.val + " === " + digit);
                node.val = (int) (val / digit);
                val %= digit;
                digit /= 10;
                node = node.next;
            }

            return dummy.next;
        }
    }
}