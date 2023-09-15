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
    private int p = 0;
    private int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p = 0;
        i = 0;
        return this.recursive(preorder, inorder, -3001);
    }

    private TreeNode recursive(int[] preorder, int[] inorder, int parentVal) {
        if (p >= preorder.length) return null;
        if (inorder[i] == parentVal) {
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = this.recursive(preorder, inorder, node.val);
        node.right = this.recursive(preorder, inorder, parentVal);
        return node;
    }
    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        else if (preorder.length == 1) return new TreeNode(preorder[0]);

        Map<Integer, Integer> parentMap = new HashMap<>();

        for (int i = 1; i < inorder.length; ++i) {
            parentMap.put(inorder[i], inorder[i-1]);
        }

        TreeNode ans = new TreeNode(preorder[0]);

        this.recursive(ans, 1, preorder, parentMap);

        return ans;
    }

    private int recursive(TreeNode parentNode, int index, int[] preorder,
                                         Map<Integer, Integer> parentMap) {
        
        // 좌측 뿌리 결정 조건
        System.out.println(index + " ==> check");
        if (index < preorder.length && parentMap.containsKey(parentNode.val) && parentMap.get(parentNode.val) == preorder[index]) {
            System.out.println(parentNode.val + " ==> left : " + preorder[index]);
            parentNode.left = new TreeNode(preorder[index++]);
            index = this.recursive(parentNode.left, index, preorder, parentMap);
        }

        System.out.println(index + " ==> check");
        if (index < preorder.length &&
            ((parentMap.containsKey(preorder[index]) && parentMap.get(preorder[index]) == parentNode.val) ||
            parentNode.val == preorder[0])) {
            System.out.println(parentNode.val + " ==> right : " + preorder[index]);
            parentNode.right = new TreeNode(preorder[index++]);
            index = this.recursive(parentNode.right, index, preorder, parentMap);
        }

        return index;
    }
    */
}