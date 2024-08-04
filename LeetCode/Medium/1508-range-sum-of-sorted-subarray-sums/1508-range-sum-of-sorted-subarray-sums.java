class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {

        int[] newRange = new int[nums.length * (nums.length + 1) / 2];
        int idx = 0;
        int modulo = 1_000_000_007;

        for (int i = 0; i < nums.length; ++i) {
            newRange[idx++] = nums[i];
            for (int j = i+1; j < nums.length; ++j) {
                newRange[idx] = newRange[idx-1] + nums[j];
                idx++;
            }
        }

        Arrays.sort(newRange);
        int sum = 0;
        // System.out.println(Arrays.toString(newRange));
        for (left--; left < right; ++left) {
            sum += newRange[left];
            sum %= modulo;
        }

        return sum;
    }
}