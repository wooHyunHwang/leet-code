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
    public int pairSum(ListNode head) {
        
        int idx = 1;
        ListNode temp = head;
        while(temp.next.next != null) {
            temp = temp.next.next;
            idx++;
        }

        int ans = 0;
        int[] stack = new int[idx + 1];
        temp = head;
        int s = 1;
        boolean check = true;
        while(temp != null) {
            if(check) {
                stack[s] = temp.val;
                if(s != idx) s++;
                else {
                    check = false;

                }
            } else {
                ans = Math.max(ans, stack[s--] + temp.val);
            }
            

            temp = temp.next;
        }
        return ans;
    }
}