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
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode back = head;
        ListNode one = head;
        ListNode two = head.next;

        while(two != null && two.next != null) {
            back = one;
            one = one.next;
            two = two.next.next;
        }

        if(two != null) {
            one.next = one.next.next;
        }
        else {
            back.next = one.next;
            one.next = null;
        }

        return head;
    }


    // 배열에 주소 저장
    public ListNode deleteMiddle2(ListNode head) {

        ListNode[] tempList = new ListNode[100_000];

        int idx = 0;
        ListNode temp = head;

        while(true) {
            tempList[idx++] = temp;
            temp = temp.next;
            if(temp == null) break;
        }

        // System.out.println(idx);

        // for(int i = 0; i < tempList.length; ++i) {
        //     if(tempList[i] == null) break;
        //     System.out.print(tempList[i].val);
        //     System.out.print(" / ");
        // }
        // System.out.println();
        // System.out.println((idx / 2 - 1) + " / " + (idx / 2 + 1));
        if(idx == 1) return null;

        if(tempList[idx / 2 + 1] != null) tempList[idx / 2 - 1].next = tempList[idx / 2 + 1];
        else tempList[idx / 2 - 1].next = null;

        return head;
    }
}