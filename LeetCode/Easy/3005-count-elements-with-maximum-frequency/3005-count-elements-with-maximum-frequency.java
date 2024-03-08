class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxCount = 0;
        int ans = 0;
        int[] ary = new int[101];

        for (int n : nums) {
            if (maxCount < ++ary[n]) {
                ans = 1;
                maxCount = ary[n];
            }
            else if (maxCount == ary[n]) {
                ans++;
            }
        }

        return ans * maxCount;
    }
}