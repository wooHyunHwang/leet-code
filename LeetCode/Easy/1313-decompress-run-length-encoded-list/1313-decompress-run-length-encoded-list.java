class Solution {
    public int[] decompressRLElist(int[] nums) {
        int space = 0;
        for (int i = 0; i < nums.length; i += 2) {
            space += nums[i];
        }

        int[] ans = new int[space];

        int k = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            Arrays.fill(ans, k, k+nums[i], nums[i+1]);
            k += nums[i];
            /*
            int temp = nums[i+1];
            for (int j = 0; j < nums[i]; ++j) {
                ans[k++] = temp;
            }
            */
        }

        return ans;
    }
}