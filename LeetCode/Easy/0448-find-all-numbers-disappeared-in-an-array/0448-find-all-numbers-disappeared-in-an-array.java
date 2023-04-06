class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] checker = new int[nums.length + 1];

        for (int n : nums) {
            checker[n]++;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < checker.length; ++i) {
            if(checker[i] == 0) ans.add(i);
        }

        return ans;
    }
}