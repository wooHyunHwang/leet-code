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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {

        if(root == null) return 0;

        ans = 0;
        this.leftDfs(root, targetSum, new long[1_002], 0);

        return ans;
    }

    private void leftDfs(TreeNode node, int targetSum, long[] accum, int idx) {
        
        accum[idx + 1] = accum[idx] + node.val;
        idx++;

        this.judgment(targetSum, accum, idx);

        if(node.left != null) leftDfs(node.left, targetSum, accum, idx);
        if(node.right != null) rightDfs(node.right, targetSum, accum.clone(), idx);

        // if(node.left == null && node.right == null) this.judgment(targetSum, queue, idx - 1);
    }

    private void rightDfs(TreeNode node, int targetSum, long[] accum, int idx) {

        accum[idx + 1] = accum[idx] + node.val;
        idx++;

        this.judgment(targetSum, accum, idx);

        if(node.left != null) leftDfs(node.left, targetSum, accum.clone(), idx);
        if(node.right != null) rightDfs(node.right, targetSum, accum, idx);

        // if(node.left == null && node.right == null) this.judgment(targetSum, queue, idx - 1);
    }

    private void judgment(int targetSum, long[] accum, int lastIdx) {
        // System.out.println("/////////////////////////////// " + accum[lastIdx]);
        for(int i = 0; i < lastIdx; ++i) {
            if(accum[lastIdx] - accum[i] == targetSum) this.ans++;
        }
    }

    /*
    private void judgment(int targetSum, int[] queue, int lastIdx) {
        // Accumulated sum
        int[] accum = new int[lastIdx + 2];

        for(int i = 0; i <= lastIdx; ++i) {
            accum[i + 1] = queue[i] + accum[i];
            System.out.println(accum[i + 1]);

            for(int j = 0; j <= i; ++j) {
                System.out.print("-- " + accum[i + 1] + " -- " + accum[j]);
                if(accum[i + 1] - accum[j] == targetSum) {
                    System.out.print(" ======= 확인");
                    this.ans++;
                }
                System.out.println();
            }
        }

        System.out.println("//////////");
        

    }
    */
}





























