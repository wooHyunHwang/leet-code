class Solution {
    final long m = 1_000_000_007;
    long[] cache = new long[0];
    public int numTilings(int n) {

        switch(n) {
            case 1: return 1;
            case 2: return 2;
            case 3: return 5;
        }

        cache = new long[n];

        cache[0] = 1L;
        cache[1] = 2L;
        cache[2] = 5L;

        int i = 3;

        while(i < n) {

            cache[i] = ((cache[i - 1] * 2) + cache[i - 3]) % m;

            // System.out.println(cache[i] + " = " + ((cache[i - 1] * 2) + " + " + cache[i - 3]));

            i++;
        }
        return (int)(cache[n-1] % m);
    }
}
// 1  2  3  4  5  6  7   8   9   10
// 1  2  5  11 24 53 117 258 569 1255