class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int sum = 0;

        // 첫번째 평균값
        for(; i < k; ++i) {
            sum += nums[i];
        }

        int maxSum = sum;

        while(i < nums.length) {

            sum += (nums[i] - nums[i - k]);

            maxSum = Math.max(maxSum, sum);

            ++i;
        }

        return (double)maxSum / k;
    }
}