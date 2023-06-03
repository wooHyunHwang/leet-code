class Solution {
    public int maxOperations(int[] nums, int k) {

        if(nums.length == 0) return 0;

         Arrays.sort(nums);

        int ans = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            
            int sum = nums[left] + nums[right];

            if(sum == k) {
                ans++;
                left++;
                right--;
            }
            else if (sum < k) left++;
            else right--;
        }

        return ans;
    }
}