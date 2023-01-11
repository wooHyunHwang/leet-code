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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 시작이 null인 경우
        if(list1 == null && list2 == null) {
            return null;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else if (list1 == null && list2 != null) {
            return list2;
        } else {
            ListNode result = null;
            ListNode last = null;

            while(list1 != null || list2 != null) {
                int cur;
                if(list2 == null) {
                    cur = list1.val;
                    list1 = list1.next;
                } else if(list1 == null) {
                    cur = list2.val;
                    list2 = list2.next;
                } else if(list1.val < list2.val) {
                    cur = list1.val;
                    list1 = list1.next;
                } else {
                    cur = list2.val;
                    list2 = list2.next;
                }

                last = zxc(last, cur);
                if(result == null) {
                    result = last;
                }
             
            }
            
            return result;
        }
    }

    private ListNode zxc(ListNode asd, int cur) {
        if(asd == null) {
            asd = new ListNode(cur);
            return asd;
        } else {
            asd.next = new ListNode(cur);
            return asd.next;
        }
    }
}