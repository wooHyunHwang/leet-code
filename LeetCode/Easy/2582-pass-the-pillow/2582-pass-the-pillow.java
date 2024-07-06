class Solution {
    public int passThePillow(int n, int time) {
        int pass = n-1;
        int direction = time / pass % 2; // 0 : right, 1 : left
        int remain = time % pass; // right : 1+, left : n-

        return direction == 0
             ? 1+remain
             : n-remain;
    }
}