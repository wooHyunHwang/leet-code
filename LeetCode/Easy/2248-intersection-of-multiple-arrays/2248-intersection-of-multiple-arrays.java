class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] history = new int[1001];
        for (int[] na : nums) {
            for (int i : na) {
                history[i]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < history.length; ++i) {
            if (history[i] == nums.length) {
                ans.add(i);
            }
        }
        return ans;
    }
}