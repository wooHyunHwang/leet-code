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
    public int[][] spiralMatrix(int m, int n, ListNode node) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < ans.length; ++i) {
            for (int j = 0; j < ans[i].length; ++j) {
                ans[i][j] = -1;
            }
        }

        int x = 0;
        int y = 0;
        int xDirection = 0;
        int yDirection = 1;

        while(node != null) {
            // System.out.println(x + "   :   " + y);
            if (ans[x][y] != -1) break;
            ans[x][y] = node.val;

            if (xDirection == 1) {
                if (x < m - 1 && ans[x+1][y] == -1) {
                    x++;
                }
                else {
                    y--;
                    xDirection = 0;
                    yDirection = -1;
                }
            }
            else if (xDirection == -1) {
                if (x > 0 && ans[x-1][y] == -1) {
                    x--;
                }
                else {
                    y++;
                    xDirection = 0;
                    yDirection = 1;
                }
            }
            else if (yDirection == 1) {
                if (y < n - 1 && ans[x][y+1] == -1) {
                    y++;
                }
                else {
                    x++;
                    xDirection = 1;
                    yDirection = 0;
                }
            }
            else if (yDirection == -1) {
                if (y > 0 && ans[x][y-1] == -1) {
                    y--;
                }
                else {
                    x--;
                    xDirection = -1;
                    yDirection = 0;
                }

            }

            node = node.next;
        }


        return ans;
    }
}