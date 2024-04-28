class Solution {
    public boolean divideArray(int[] nums) {

        int[] history = new int[501];
        int count = 0;

        for (int n : nums) {
            history[n]++;

            if (history[n] % 2 == 0) count--;
            else count++;
        }

        return count == 0;
    }
}