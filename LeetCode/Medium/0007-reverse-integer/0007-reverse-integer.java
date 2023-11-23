class Solution {
    public int reverse(int x) {

        boolean positive = x > 0;
        int positive10 = 214748364;
        int negative10 = -214748364;

        int i = 0;
        int ans = 0;
        
        while(x != 0) {
            int cur = x % 10;
            x /= 10;

            i++;

            if (i > 9) {
                if ((positive && (ans > positive10 || (ans == positive10 && cur > 7))) ||
                    (!positive  && (ans < negative10 || (ans == negative10 && cur < -8)))
                ) {
                    return 0;
                }
            }

            ans *= 10;
            ans += cur;
        }

        return ans;

    }
}