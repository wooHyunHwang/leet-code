class Solution {
    public long largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        int maxIndex = 0;
        int i = 0;
        long ans = 0L;

        for (; i < nums.length; ++i) {
            ans += nums[i];
        }
        i--;
        for (; i > 1; --i) {
            long temp = ans - nums[i];
            if (temp > nums[i]) return ans;
            else ans = temp;
        }

        return -1L;
    }
}