class Solution {
    public double minimumAverage(int[] nums) {

        double small = Double.MAX_VALUE;
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;

        while (l < r) {
            small = Math.min(
                small,
                ((double)nums[l++] + (double)nums[r--]) / 2
            );
        }
        return small;
    }
}
// 15, 1 16  8
// 3, 13 16  8
// 8, 4 12  6
// 7, 4 11  5.5