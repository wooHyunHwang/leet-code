class Solution {
    public int arrangeCoins(int n) {
        // 16bit (max)
        int digit = 1 << 15;
        long ans = 0;

        while(digit > 0) {

            long temp = ans | digit;
            long fill = temp * (temp + 1) / 2;

            if (fill == n) return (int) temp;
            if (fill < n) ans = temp;

            digit >>= 1;
        }

        return (int)ans;
    }
    public int arrangeCoins2(int n) {
        int ans = 0;
        int i = 1;

        while (true) {
            n -= i++;
            if (n > -1) ans++;
            else break;
        }

        return ans;
    }
}