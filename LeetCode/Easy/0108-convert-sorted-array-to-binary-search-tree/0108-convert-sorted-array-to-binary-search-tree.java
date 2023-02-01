/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) return null;

        int midIdx = nums.length / 2;

        // System.out.println("시작값 : " + nums[midIdx]);

        return new TreeNode(
            nums[midIdx],
            findNextMid(0, midIdx - 1, nums),
            findNextMid(midIdx + 1, nums.length - 1, nums)
        );
    }

    public TreeNode findNextMid(int start, int end, int[] nums) {
        // left, right의 마지막 경우
        if(start > end || start > end) {
            // System.out.println("Return Null");
            return null;
        } else if (start == end) {
            // System.out.println("last Tree : " + nums[start]);
            return new TreeNode(nums[start]);
        }

        int midIdx = (start + end) / 2;

        // print(midIdx, start, end, nums);

        return new TreeNode(
            nums[midIdx],
            findNextMid(start, midIdx - 1, nums),
            findNextMid(midIdx + 1, end, nums)
        );

    }

    public void print(int midIdx, int start, int end, int[] nums) {
        System.out.println("############################################");

        System.out.println("배열 : [0,1,2,3,4,5]");
        System.out.println("시작 idx : " + start + " / 종료 idx : " + end);
        System.out.println("이번값 : " + nums[midIdx]);
        System.out.println("다음 좌측 idx : " + start + " / " + (midIdx - 1));
        System.out.println("다음 우측 idx : " + (midIdx + 1) + " / " + end);

    }
}














