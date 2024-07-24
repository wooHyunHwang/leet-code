class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                zeroCount++;
            }
        }

        return zeroCount > 1;
    }
}