class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int ans = 0;
        int[] sum = new int[nums.length];
        Map<Integer, Integer> dup = new HashMap<>();

        sum[0] = (nums[0] % k + k) % k;
        for(int i = 1; i < nums.length; ++i) {

            sum[i] = sum[i - 1] + (nums[i] % k) + k;
            sum[i] %= k;

        }

        for(int i = 0; i < sum.length; ++i) {

            if (dup.containsKey(sum[i])) {
                ans += dup.get(sum[i]);
                dup.put(sum[i], dup.get(sum[i]) + 1);
            } else {
                dup.put(sum[i], 1);

                if (sum[i] == 0) {
                    ans++;
                    dup.put(sum[i], 2);
                }
            }
        }

        return ans;
    }
}