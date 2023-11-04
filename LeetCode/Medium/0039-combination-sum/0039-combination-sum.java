class Solution {
    List<List<Integer>> ans = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.ans = new ArrayList<>();

        this.dfs(candidates, target, new ArrayList<>(), 0, 0);

        return ans;
    }

    private void dfs(int[] candidates, int target, List<Integer> ary, int stack, int i) {

        for (; i < candidates.length; ++i) {
            int sum = stack + candidates[i];

            if (sum == target) {
                // find
                List<Integer> copy = new ArrayList<>(ary);
                copy.add(candidates[i]);

                this.ans.add(copy);

            } else if (sum < target) {
                // next
                ary.add(candidates[i]);

                this.dfs(candidates, target, ary, sum, i);

                ary.remove(ary.size() - 1);
            }
        }
    }
}