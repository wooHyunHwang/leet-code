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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        ans.add(new ArrayList<>());
        ans.get(0).add(root.val);

        ans = findRoot(ans, root, 1);

        for (int i = 0; i < ans.size(); ++i) {
            if (i % 2 == 1) {
                Collections.reverse(ans.get(i));
            }
        }

        return ans;
        
    }

    public List<List<Integer>> findRoot(List<List<Integer>> ans,
                                        TreeNode node, int index) {
        
        if (node == null || (node.left == null && node.right == null)) return ans;

        // 현재 순서의 리스트 생성 확인, 없다면 초기화
        if(ans.size() - 1 < index) {
            ans.add(new ArrayList<>());
        }

        // INDEX 2의 나머지
        // int remain = index % 2;
        int nextIdx = index + 1;

        /**
         * 값 추가 부분
         * INDEX 2의 나머지가 0이면 현재 단계는 좌측 우선, 1이면 우측 우선
         */
        if (node.left != null) {
            ans.get(index).add(node.left.val);
        }
        if (node.right != null) {
            ans.get(index).add(node.right.val);
        }

        /**
         * 다음 회차 실행
         * INDEX 2의 나머지가 0이면 다음 단계는 우측 우선, 1이면 좌측 우선
         */

        if (node.left != null) {
            findRoot(ans, node.left, nextIdx);
        }

        if (node.right != null) {
            findRoot(ans, node.right, nextIdx);
        }

        return ans;
    }

















}