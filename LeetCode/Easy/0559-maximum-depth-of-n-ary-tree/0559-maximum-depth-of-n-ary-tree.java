/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        return this.findMaxDepth(root, 1);
    }

    public int findMaxDepth(Node node, int depth) {

        if (node.children == null || node.children.isEmpty()) {
            return depth;
        }

        int maxDepth = 0;

        for (Node child : node.children) {
            maxDepth = Math.max(
                maxDepth,
                this.findMaxDepth(child, depth+1)
            );
        }

        return maxDepth;
    }
}