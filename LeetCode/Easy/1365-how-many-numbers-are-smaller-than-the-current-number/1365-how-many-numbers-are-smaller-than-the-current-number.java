class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int[] count = new int[101];

        for (int i = 0; i < nums.length; ++i) {
            count[nums[i]]++;
        }

        for (int i = 1; i <= 100; ++i) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) ans[i] = 0;
            else ans[i] = count[nums[i] - 1];
        }

        return ans;
    }
    public int[] smallerNumbersThanCurrent2(int[] nums) {

        int[] ans = new int[nums.length];
        int[] sorted = new int[nums.length];
        System.arraycopy(
            nums, 0,
            sorted, 0,
            nums.length
        );

        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < sorted.length; ++j) {
                if (sorted[j] == nums[i]) {
                    ans[i] = j;
                    break;
                }
            }
        }


        return ans;
    }
}