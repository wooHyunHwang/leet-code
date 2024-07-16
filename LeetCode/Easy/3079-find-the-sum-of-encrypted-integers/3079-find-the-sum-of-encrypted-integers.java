class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            int max = 0;
            int digit = 0;

            while(n != 0) {
                max = Math.max(max, n % 10);
                n /= 10;
                digit++;
            }

            int val = 0;
            while(digit != 0) {
                val *= 10;
                val += max;
                digit--;
            }
            sum += val;
        }

        return sum;
    }
}