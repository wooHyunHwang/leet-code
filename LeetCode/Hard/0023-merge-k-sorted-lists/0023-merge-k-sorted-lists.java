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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode();
        ListNode node = temp;

        int live = 0;
        for (ListNode n : lists) {
            if (n != null) live++;
        }
        
        while(live > 0) {

            // System.out.println(" ===== " + live);

            int idx = -1;
            int min = 10001;

            for (int i = 0; i < lists.length; ++i) {
                // if (lists[i] != null)  System.out.print(lists[i].val + " / ");
                
                if (lists[i] != null && lists[i].val < min) {
                    idx = i;
                    min = lists[i].val;
                }

            }

            if (idx != -1) {
                // System.out.println(idx + " = " + lists[idx].val);
                temp.next = lists[idx];
                temp = temp.next;
                lists[idx] = lists[idx].next;
                if (lists[idx] == null) {
                    // System.out.println("마지마아아아악");
                    live--;
                }
            }

        }

        return node.next;
    }
}