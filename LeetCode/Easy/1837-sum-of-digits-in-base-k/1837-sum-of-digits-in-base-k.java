class Solution {
    public int sumBase(int n, int k) {
        int ans = 0;
        int div = (int)Math.pow(k, 7);

        while(n != 0) {
            ans += n / div;
            n %= div;
            div /= k;
        }

        return ans;
    }
}