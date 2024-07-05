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
    public int[] nodesBetweenCriticalPoints(ListNode node) {
        int[] ans = {-1, -1};
        int idx = 1;
        int firstStrictlyIdx = -1;
        int findStrictlyIdx = -1;
        int beforeStrictlyIdx = -1;
        int minimum = Integer.MAX_VALUE;

        // 첫번째 좌표 찾기
        while (node.next.next != null) {

            idx++;

            if (
                (node.val < node.next.val && node.next.next.val < node.next.val) ||
                (node.val > node.next.val && node.next.next.val > node.next.val)
            ) {
                // Maxima or Minima
                // System.out.println("First Maxima or Minima : " + node.next.val + " : " + idx);
                firstStrictlyIdx = idx;
                findStrictlyIdx = idx;
                beforeStrictlyIdx = idx;

                node = node.next;
                break;
            }
            else {
                node = node.next;
            }
        }

        while (node.next.next != null) {

            idx++;
            
            if (
                (node.val < node.next.val && node.next.next.val < node.next.val) ||
                (node.val > node.next.val && node.next.next.val > node.next.val)
            ) {
                // Maxima or Minima
                // System.out.println("Find Maxima or Minima : " + node.next.val + " : " + idx);
                beforeStrictlyIdx = findStrictlyIdx;
                findStrictlyIdx = idx;
                minimum = Math.min(minimum, findStrictlyIdx - beforeStrictlyIdx);
            }

            node = node.next;
        }

        // System.out.println("firstStrictlyIdx : " + firstStrictlyIdx);
        // System.out.println("findStrictlyIdx : " + findStrictlyIdx);
        // System.out.println("beforeStrictlyIdx : " + beforeStrictlyIdx);
        if (firstStrictlyIdx != -1 && firstStrictlyIdx != findStrictlyIdx) {
            ans[0] = minimum;
            ans[1] = findStrictlyIdx - firstStrictlyIdx;
        }
        
        return ans;
    }
}