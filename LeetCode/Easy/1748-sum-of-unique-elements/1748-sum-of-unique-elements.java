class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] history = new int[101];

        for (int n : nums) {
            if (history[n] == 0) {
                sum += n;
            }
            else if (history[n] == 1) {
                sum -= n;
            }
            history[n]++;
        }

        return sum;
    }
}