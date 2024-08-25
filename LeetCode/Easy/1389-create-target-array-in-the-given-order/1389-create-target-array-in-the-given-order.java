class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            list.add(index[i], nums[i]);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = list.get(i);
        }


        return ans;
    }
    public int[] createTargetArray2(int[] nums, int[] index) {

        List<Integer> list = new LinkedList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            list.add(index[i], nums[i]);
        }


        return list.stream().mapToInt(i->i).toArray();
    }
}
