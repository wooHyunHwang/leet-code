class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;

        while(n != 0) {
            n /= 5;
            ans += n;
        }

        return ans;
    }
}
/*
0 - 1 - 1
0 - 2 - 2
0 - 3 - 6
0 - 4 - 24
1 - 5 - 120
1 - 6 - 720
1 - 7 - 5040
1 - 8 - 40320
1 - 9 - 362880
2 - 10 - 3628800
2 - 11 - 39916800
2 - 12 - 479001600
2 - 13 - 6227020800
2 - 14 - 87178291200
3 - 15 - 1307674368000
3 - 16 - 20922789888000
3 - 17 - 355687428096000
3 - 18 - 6402373705728000
3 - 19 - 121645100408832000
4 - 20 - 2432902008176640000
*/