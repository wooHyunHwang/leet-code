class Solution {
    public int arraySign(int[] nums) {

        if(nums.length == 0) return 0;

        int minus = 0;

        for (int n : nums) {
            if(n < 0) {
                minus++;
            } else if (n == 0) {
                return 0;
            }
        }

        return minus % 2 == 0 ? 1 : -1;
    }
}