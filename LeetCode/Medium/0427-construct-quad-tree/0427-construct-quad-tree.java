/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {

        if (grid.length == 1) {
            return new Node(
                grid[0][0] == 1,
                true
            );
        }

        Node ans = this.recursive(grid, 0, grid.length - 1, 0, grid.length - 1);

        // System.out.println("[" + (ans.isLeaf ? "1" : "0") + "," + (ans.val ? "1" : "0") + "],");
        // print(ans);

        return ans;
    }

    private Node recursive(int[][] grid, int stW, int edW, int stH, int edH) {
        // System.out.println(stW + " - " + edW + " / " + stH + " - " + edH);

        if (edW - stW == 1 && edH - stH == 1) {
            // 구분이 가능한 그룹
            // System.out.println("@@ " + grid[stW][stH] + " / " + grid[stW][edH]);
            // System.out.println("@@ " + grid[edW][stH] + " / " + grid[edW][edH]);

            boolean isLeaf = grid[stW][stH] == grid[stW][edH] &&
                            grid[stW][edH] == grid[edW][stH] &&
                            grid[edW][stH] == grid[edW][edH];

            return new Node(
                // val은 isLeaf가 true일때만 가치가 있는 값임
                grid[stW][stH] == 1,
                // 모든 값이 같으면 isLeaf = true(1)
                isLeaf,
                !isLeaf ? new Node(grid[stW][stH] == 1, true) : null,
                !isLeaf ? new Node(grid[stW][edH] == 1, true) : null,
                !isLeaf ? new Node(grid[edW][stH] == 1, true) : null,
                !isLeaf ? new Node(grid[edW][edH] == 1, true) : null
            );
        } else {
            // 다음 그룹
            int addW = (edW - stW) / 2 + stW;
            int addH = (edH - stH) / 2 + stH;

            Node topLeft = this.recursive(grid, stW, addW, stH, addH);
            Node topRight = this.recursive(grid, stW, addW, addH + 1, edH);
            Node bottomLeft = this.recursive(grid, addW + 1, edW, stH, addH);
            Node bottomRight = this.recursive(grid, addW + 1, edW, addH + 1, edH);

            // System.out.println("============== > " + (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf));
            // System.out.println("============== > " + (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val));

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                // System.out.println("자식이 널");
                return new Node(
                    topLeft.val,
                    true
                );
            } else {
                // System.out.println("자식이 있어");
                return new Node(
                    topLeft.val,
                    false,
                    topLeft,
                    topRight,
                    bottomLeft,
                    bottomRight
                );
            }

        }
    }

    void print(Node node) {
        if (node == null || 
            (node.topLeft == null && node.topRight == null && node.bottomLeft == null && node.bottomRight == null)
        ) return;
        System.out.print("tl");
        if (node.topLeft != null) {
            System.out.print("[" + (node.topLeft.isLeaf ? "1" : "0") + "," + (node.topLeft.val ? "1" : "0") + "],");
        } else {
            System.out.print("null,");
        }

        System.out.print("tr");
        if (node.topRight != null) {
            System.out.print("[" + (node.topRight.isLeaf ? "1" : "0") + "," + (node.topRight.val ? "1" : "0") + "],");
        } else {
            System.out.print("null,");
        }

        System.out.print("bl");
        if (node.bottomLeft != null) {
            System.out.print("[" + (node.bottomLeft.isLeaf ? "1" : "0") + "," + (node.bottomLeft.val ? "1" : "0") + "],");
        } else {
            System.out.print("null,");
        }

        System.out.print("br");
        if (node.bottomRight != null) {
            System.out.print("[" + (node.bottomRight.isLeaf ? "1" : "0") + "," + (node.bottomRight.val ? "1" : "0") + "],");
        } else {
            System.out.print("null,");
        }

        System.out.println();
        System.out.println();

        System.out.println(">>> topLeft");
        this.print(node.topLeft);
        System.out.println(">>> topRight");
        this.print(node.topRight);
        System.out.println(">>> bottomLeft");
        this.print(node.bottomLeft);
        System.out.println(">>> bottomRight");
        this.print(node.bottomRight);
    }
}





























