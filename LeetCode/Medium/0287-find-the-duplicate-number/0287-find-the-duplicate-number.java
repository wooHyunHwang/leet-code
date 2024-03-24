class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] du = new boolean[nums.length];

        for (int n : nums) {
            if (du[n]) return n;
            du[n] = true;
        }
        return -1;
    }
}