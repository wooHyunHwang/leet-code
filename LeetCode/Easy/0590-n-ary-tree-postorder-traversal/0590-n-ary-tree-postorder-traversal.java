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
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        this.ans = new ArrayList<>();

        this.dfs(root);

        return this.ans;
    }

    private void dfs(Node node) {

        if (node == null) return;
        if (node.children != null && !node.children.isEmpty()) {
            for (Node n : node.children) {
                this.dfs(n);
            }
        }

        this.ans.add(node.val);
    }
}