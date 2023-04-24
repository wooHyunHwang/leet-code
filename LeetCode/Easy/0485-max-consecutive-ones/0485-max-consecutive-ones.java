class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == 0) {
                max = Math.max(max, temp);
                temp = 0;
            } else {
                temp++;
            }
        }
        return Math.max(max, temp);
    }
}