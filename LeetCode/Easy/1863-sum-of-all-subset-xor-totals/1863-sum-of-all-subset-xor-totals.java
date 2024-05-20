class Solution {
    public int subsetXORSum(int[] nums) {

        return this.recursive(nums, nums.length, 0, 0);
    }

    private int recursive(int[] nums, int len, int value, int idx) {

        if (idx == len) return value;

        int next = idx+1;

        return this.recursive(nums, len, value ^ nums[idx], next) +
                this.recursive(nums, len, value, next);
    }
}