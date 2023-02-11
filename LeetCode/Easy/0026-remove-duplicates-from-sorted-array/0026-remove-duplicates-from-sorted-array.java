class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 0) return 0;

        int idx = 0;
        int next = nums[0];
        
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] >= next) {
                nums[idx] = nums[i];
                next = nums[i] + 1;
                idx++;
            }
        }
        return idx;
    }
}