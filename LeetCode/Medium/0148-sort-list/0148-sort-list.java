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

    public ListNode sortList2(ListNode head) {

        return this.quickSort(head, null);
    }
    private ListNode quickSort(ListNode start, ListNode until) {
        if (start == null || start.next == null || start.next == until || start == until) {
            return start;
        }
        
        ListNode head = start;
        ListNode mid = start;
        int pivot = start.val;
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        boolean sorted = true;
        while (curr != until) {
            sorted = sorted && (prev.val <= curr.val);
            ListNode next = curr.next;
            if (curr.val <= pivot) {
                prev.next = next;
                curr.next = head;
                head = curr;
            } else {
                prev = curr;
            }
            curr = next;
        }
        
        if (sorted) {
            return head;
        }
        
        ListNode newHead = quickSort(head, mid);        
        ListNode newMid = quickSort(mid.next, until);
        mid.next = newMid;
        
        return newHead;        
    }



    public ListNode sortList(ListNode head) {

        if (head == null) return head;

        ListNode temp = new ListNode(-100_001);

        temp.next = head;
        ListNode prev = head;
        ListNode tail = head.next;

        while(tail != null) {
            // System.out.println("======== " + tail.val);
            if (prev.val < tail.val) {
                // System.out.println("다음...");
                prev = tail;
                tail = tail.next;
                continue;
            }

            ListNode next = tail.next;
            ListNode find = temp;
            while(find.next != null) {
                // System.out.println("비교 : " + find.val + " - " + find.next.val);
                if (find.val < tail.val && tail.val <= find.next.val) {
                    tail.next = find.next;
                    find.next = tail;
                    tail = next;
                    prev.next = tail;
                    break;
                } else {
                    find = find.next;
                }
                
            }
        }
        return temp.next;
    }
}