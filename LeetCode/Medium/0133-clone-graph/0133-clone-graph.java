/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node[] history = new Node[101];
    private Node ans = new Node();
    public Node cloneGraph(Node node) {
        
        if (node == null) return null;

        history = new Node[101];
        ans = new Node();

        List<Node> dummy = new ArrayList<>();
        dummy.add(node);

        this.cloneHelper(ans.neighbors, dummy);

        return ans.neighbors.get(0);
    }


    private void cloneHelper(List<Node> parentNeighbors, List<Node> next) {

        if (next == null) return;

        for (int i = 0; i < next.size(); ++i) {
            // System.out.println(" == " + next.get(i).val);
            if (history[next.get(i).val] != null) {
                // System.out.println("이미 있는데?");
                parentNeighbors.add(history[next.get(i).val]);
                continue;
            }

            // System.out.println(next.get(i).val);
            Node clone = new Node(next.get(i).val);
            history[next.get(i).val] = clone;

            this.cloneHelper(clone.neighbors, next.get(i).neighbors);

            parentNeighbors.add(clone);
            
        }

    }
}






























