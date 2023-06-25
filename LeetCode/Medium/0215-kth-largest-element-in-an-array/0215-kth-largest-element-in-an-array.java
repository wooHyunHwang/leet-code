class Solution {
    public int findKthLargest(int[] nums, int k) {

        int max = nums[0];
        int min = nums[0];

        for(int i = 0; i < nums.length; ++i) {
            max = max < nums[i] ? nums[i] : max;
            min = min > nums[i] ? nums[i] : min;
        }

        int div = max - min + 1;
        int temp[] = new int[div];

        for(int i = 0; i < nums.length; ++i) {
            temp[nums[i] - min]++;
        }

        for(int i = div - 1; i >= 0; --i) {
            k -= temp[i];
            if(k <= 0) return i + min;
        }

        return 0;

    }
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}