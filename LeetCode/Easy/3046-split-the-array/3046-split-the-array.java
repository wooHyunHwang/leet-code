class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] his = new int[101];
        for (int n : nums) {
            his[n]++;
            if (his[n] > 2) return false;
        }
        return true;
    }
}