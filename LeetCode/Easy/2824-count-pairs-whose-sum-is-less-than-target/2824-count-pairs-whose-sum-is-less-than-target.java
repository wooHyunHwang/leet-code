class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int pre = nums.get(i);
            for (int j = i+1; j < n; ++j) {
                if (pre + nums.get(j) < target) count++;
            }
        }
        return count;
    }
}