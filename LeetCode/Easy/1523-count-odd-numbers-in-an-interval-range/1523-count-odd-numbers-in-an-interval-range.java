class Solution {
    public int countOdds(int low, int high) {
        int div = (high - low) / 2;

        return low % 2 == 0 && high % 2 == 0 ? div: div +1;
    }
}
