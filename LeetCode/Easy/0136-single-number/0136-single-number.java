class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> history = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            history.put(
                nums[i],
                history.getOrDefault(nums[i], 0) + 1
            );

        }

        for (Integer key : history.keySet()) {
            if (1 == history.get(key)) {
                return key;
            }
        }
        return -1;
    }
}