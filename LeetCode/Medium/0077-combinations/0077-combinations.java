class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        this.dfs(
            new ArrayList<>(),
            1,
            n,
            k
        );

        return ans;
    }

    private List<Integer> copyList(List<Integer> list) {
        return new ArrayList<>(list);
    }

    private void dfs(List<Integer> temp, int value, int maxValue, int reverseDepth) {

        if (reverseDepth == 0) {
            ans.add(this.copyList(temp));
            return;
        }

        for (int i = value; i <= maxValue - reverseDepth + 1; ++i) {
            temp.add(i);
            if (reverseDepth > 0) this.dfs(temp, i + 1, maxValue, reverseDepth - 1);
            temp.remove(temp.size() - 1);
        }
    }
}