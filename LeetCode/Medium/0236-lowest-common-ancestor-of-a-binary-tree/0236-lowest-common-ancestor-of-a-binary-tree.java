/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 자식 값 / 부모 노드
        Map<Integer, TreeNode> parentCache = new HashMap<>();

        parentCache = this.createCacheByDfs(parentCache, root, p, q, false, false);

        // p의 Set 생성
        Set<Integer> pParentVal = new HashSet<>();
        int pVal = p.val;
        pParentVal.add(pVal);
        while(parentCache.containsKey(pVal)) {
            TreeNode parent = parentCache.get(pVal);
            pVal = parent.val;
            pParentVal.add(parent.val);
        }

        // q 거슬러 올라가면서 최초로 Set에 들어있는거 만나면 return
        int qVal = q.val;
        if(pParentVal.contains(qVal)) return q;
        while(parentCache.containsKey(qVal)) {
            TreeNode parent = parentCache.get(qVal);
            qVal = parent.val;
            if(pParentVal.contains(qVal)) return parent;
        }
        return null;
    }

    private Map<Integer, TreeNode> createCacheByDfs(Map<Integer, TreeNode> parentCache,
                                    TreeNode node, TreeNode p, TreeNode q,
                                    boolean findP, boolean findQ) {

        // Break
        if(node == null) return parentCache;
        if(findP && findQ) return parentCache;

        // 값 찾음??
        if(!findP) findP = node.val == p.val;
        if(!findQ) findQ = node.val == q.val;

        if(node.left != null) parentCache.put(node.left.val, node);
        if(node.right != null) parentCache.put(node.right.val, node);

        parentCache = this.createCacheByDfs(parentCache, node.left, p, q, false, false);
        return this.createCacheByDfs(parentCache, node.right, p, q, false, false);
    }
}