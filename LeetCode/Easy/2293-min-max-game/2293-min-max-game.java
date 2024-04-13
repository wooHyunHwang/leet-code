class Solution {
    public int minMaxGame(int[] nums) {

        if (nums.length == 1) return nums[0];

        int[] newNums = new int[nums.length/2];
        boolean status = true;
        for (int i = 0; i < nums.length/2; ++i) {
            int idx = i*2;
 
            if (status) {
                newNums[i] = Math.min(nums[idx], nums[idx+1]);
            }
            else {
                newNums[i] = Math.max(nums[idx], nums[idx+1]);
            }
            status = !status;
        }

        return minMaxGame(newNums);
    }

}