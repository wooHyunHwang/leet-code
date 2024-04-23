class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveCount = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                consecutiveCount++;
                if (consecutiveCount == 3) return true;
            } else {
                consecutiveCount = 0;
            }
        }
        return false;
    }
}