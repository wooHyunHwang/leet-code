class Solution {
    public int missingNumber(int[] nums) {

        boolean[] sequentially = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; ++i) {
            sequentially[nums[i]] = true;
        }
        for (int i = 0; i <= sequentially.length; ++i) {
            if (!sequentially[i]) return i;
        }

        return -1;
    }
}