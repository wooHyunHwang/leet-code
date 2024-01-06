class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int ans = 1;
        for (int i = min; i > 0; --i) {
            if (min % i == 0 && max % i == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}