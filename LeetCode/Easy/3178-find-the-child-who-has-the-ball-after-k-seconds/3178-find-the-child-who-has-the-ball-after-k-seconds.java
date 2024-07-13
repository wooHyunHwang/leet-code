class Solution {
    public int numberOfChild(int n, int k) {
        int direction = k / --n % 2; // 0 : right, 1 : left
        int remain = k % n; // right : 1+, left : n-
        // System.out.println(direction + "  :  " + remain);
        return direction == 0
             ? remain
             : n-remain;
    }
}