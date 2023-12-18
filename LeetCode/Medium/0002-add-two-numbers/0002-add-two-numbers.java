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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean rounding = false;
        ListNode dummy = new ListNode();
        dummy.next = l1;
        
        while(l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {

                l1.val += l2.val;
                if (rounding) {
                    l1.val++;
                    rounding = false;
                }
                
                if (l1.val > 9) {
                    rounding = true;
                    l1.val -= 10;
                }

                if (l1.next == null) {
                    if (l2.next != null) {
                        l1.next = l2.next;
                        l1 = l1.next;
                        l2 = null;
                    } else {
                        break;
                    }
 
                } else {
                    l1 = l1.next;
                    l2 = l2.next;
                }
                
            }
            else {
                if (rounding) {
                    l1.val++;
                    rounding = false;
                }
                if (l1.val > 9) {
                    rounding = true;
                    l1.val -= 10;
                }
                if (l1.next == null) break;
                l1 = l1.next;
            }
        }

        if (rounding) l1.next = new ListNode(1);

        return dummy.next;
    }
}