class Solution {
    public int minOperations(int[] nums, int k) {

        for (int i = 1; i < nums.length; ++i) {
            nums[0] ^= nums[i];
        }
        nums[0] ^= k;

        int count = 0;
        while(nums[0] > 0) {
            if (nums[0] % 2 == 1) count++;
            nums[0] /= 2;
        }
        return count;
    }
}
