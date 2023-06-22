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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;
        
        ListNode tempEvenHead = head.next;
        ListNode tempEven = tempEvenHead;
        ListNode tempOdd = head;

        while(true) {

            // 2개씩 넘어감
            if(tempOdd != null && tempOdd.next != null && tempOdd.next.next != null) {
                tempOdd.next = tempOdd.next.next;
                tempOdd = tempOdd.next;
            }
            else break;

            if(tempEven != null && tempEven.next != null && tempEven.next.next != null) {
                tempEven.next = tempEven.next.next;
                tempEven = tempEven.next;
            }
            else break;

        }

        tempEven.next = null;
        tempOdd.next = tempEvenHead;

        // printNode(head);

        return head;
    }

    private void printNode(ListNode node) {

        ListNode temp = node;

        while(temp != null) {
            System.out.print(temp.val + " / ");
            temp = temp.next;
        }

    }
}