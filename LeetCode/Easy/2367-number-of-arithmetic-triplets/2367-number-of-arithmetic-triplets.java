class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int diff2 = diff * 2;
        boolean[] history = new boolean[251];

        for (int n : nums) history[n] = true;

        for (int n : nums) {
            if (history[n+diff] && history[n+diff2]) count++;
        }

        return count;
    }
    public int arithmeticTriplets2(int[] nums, int diff) {
        int count = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                for (int k = j+1; k < nums.length; ++k) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) count++;
                }
            }
        }

        return count;
    }
}