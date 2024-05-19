class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] his = new int[10001];

        for (int n : nums) {
            his[n]++;
            if (his[n] > 1) return n;
        }
        return -1;
    }
}