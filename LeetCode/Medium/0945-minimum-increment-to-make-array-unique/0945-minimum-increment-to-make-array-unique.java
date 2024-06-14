class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int increment = 0;
        // for (int i = 0; i < nums.length; ++i) System.out.print(nums[i] + ", ");
        // System.out.println();
        for (int i = 1; i < nums.length; ++i) {

            if (nums[i-1] >= nums[i]) {
                increment += nums[i-1]+1 - nums[i];
                nums[i] = nums[i-1]+1;
            }

            
        }
        // for (int i = 0; i < nums.length; ++i) System.out.print(nums[i] + ", ");
        // System.out.println();
        return increment;
    }
}