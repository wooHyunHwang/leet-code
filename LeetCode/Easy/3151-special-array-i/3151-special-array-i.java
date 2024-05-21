class Solution {
    public boolean isArraySpecial(int[] nums) {
        int remain = nums[0]%2;
        for (int i = 1; i < nums.length; ++i) {
            int nextRemain = nums[i]%2;
            if (remain == nextRemain) return false;
            remain = nextRemain;
        }
        return true;
    }
}