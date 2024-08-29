class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int[] val = new int[101];
        for (int n : nums) {
            val[n]++;
        }
        for (int v : val) {
            if (v > 1) {
                count += v * (v-1) / 2;
            }
        }
        return count;
    }
}
