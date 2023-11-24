class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();

        ans.add(new ArrayList<>());

        this.recursive(nums, 0, new ArrayList<>());

        return ans;
    }

    private void recursive(int[] nums, int i, List<Integer> list) {
        
        if (i >= nums.length) return;

        

        for (int j = i; j < nums.length; ++j) {

            list.add(nums[j]);

            this.ans.add(new ArrayList<>(list));

            this.recursive(nums, j + 1, list);

            list.remove(list.size() - 1);


        }
    }
}