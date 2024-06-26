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

    private int idx = 1;

    public TreeNode balanceBST(TreeNode root) {

        /**
         * 리스트 노드 정렬 배열로 변환
         */
        this.idx = 1;
        int[] arr = recursiveExtract(new int[10001], root);

        /*
        for (int i = 1; i < idx; ++i) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        */

        /**
         * 제대로 정렬된 새로운 노드를 생성
         */
        return this.createNewTree(arr, 0, idx-1);
    }

    private int[] recursiveExtract(int[] arr, TreeNode node) {

        if (node == null) return arr;
        
        recursiveExtract(arr, node.left);

        arr[idx++] = node.val;

        recursiveExtract(arr, node.right);

        return arr;
    }

    private TreeNode createNewTree(int[] arr, int left, int right) {

        int sum = left + right;
        int center = sum / 2 + sum % 2;

        // System.out.println("left : " + left + " right : " + right + " center : " + center);
        
        if (arr[center] < 1) return null;

        TreeNode mo = new TreeNode(arr[center]);
        arr[center] = -1;

        mo.left = this.createNewTree(arr, left, center);
        mo.right = this.createNewTree(arr, center, right);

        return mo;
    }
}