class Solution {
    public int specialArray(int[] nums) {

        int[] xs = new int[1_001];

        for (int n : nums) {
            xs[n]++;
        }

        int count = 0;
        for (int i = 1000; i > 0; --i) {
            count += xs[i];
            if (i == count) return i;
        }
        return -1;
    }
}