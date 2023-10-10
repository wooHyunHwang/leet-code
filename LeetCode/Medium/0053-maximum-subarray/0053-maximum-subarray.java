class Solution {
    public int maxSubArray(int[] nums) {
        int min = (-10) * 10 * 10 * 10 - 1;
        int maxSequencialSum = min;
        int sequencialSum = min;

        for (int num : nums) {
            
            sequencialSum = Math.max(num + sequencialSum, num);
            maxSequencialSum = Math.max(maxSequencialSum, sequencialSum);
        }

        return maxSequencialSum;
    }
}