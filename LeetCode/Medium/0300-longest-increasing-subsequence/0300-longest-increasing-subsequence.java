class Solution {
    int[] dp = null;
    public int lengthOfLIS(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -10001);
        int LIS = 0;

        for(int i = 0; i < nums.length; ++i) {

            int idx = this.bs(nums[i], 0, LIS, LIS + 1);

            if (idx == -1) dp[LIS++] = nums[i];
            else dp[idx] = nums[i];
        }

        return LIS;
    }

    private int bs(int target, int left, int right, int size) {
        int ret = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= this.dp[mid]) {
                ret = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (left == size) return -1;
        else return ret;
    }
}