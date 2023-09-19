/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if (root == null) return root;

        Node wrapper = root;

        while(wrapper != null) {
            Node center = new Node();
            Node inner = center;

            while(wrapper != null) {
                if (wrapper.left != null) {
                    inner.next = wrapper.left;
                    inner = inner.next;
                }
                if (wrapper.right != null) {
                    inner.next = wrapper.right;
                    inner = inner.next;
                }
                wrapper = wrapper.next;
            }
            wrapper = center.next;
        }

        return root;

    }
    // slow solution
    public Node connect2(Node root) {

        if (root == null) return root;

        List<Node> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            List<Node> temp = new ArrayList<>();

            for (int i = 0; i < queue.size(); ++i) {
                if (queue.get(i).left != null) temp.add(queue.get(i).left);
                if (queue.get(i).right != null) temp.add(queue.get(i).right);

                // 다음 포인터 채우기
                if (i < queue.size() - 1) queue.get(i).next = queue.get(i+1);
            }

            queue = temp;
        }

        return root;
    }
}