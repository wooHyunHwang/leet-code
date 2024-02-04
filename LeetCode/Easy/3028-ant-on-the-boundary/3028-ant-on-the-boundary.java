class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int spot = 0;
        int count = 0;

        for (int n : nums) {
            spot += n;
            if (spot == 0) count++;
        }

        return count;
    }
}