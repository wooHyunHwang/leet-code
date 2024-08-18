class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        dp[0] = 1;

        for (int i = 1; i < n; ++i) {
            int v2 = dp[i2]*2;
            int v3 = dp[i3]*3;
            int v5 = dp[i5]*5;

            // System.out.print(String.format("%d %d %d", v2, v3, v5));

            int minValue = Math.min(v2, Math.min(v3, v5));

            // System.out.println(String.format(" ==== %d", minValue));

            if (v2 == minValue) i2++;
            if (v3 == minValue) i3++;
            if (v5 == minValue) i5++;
            dp[i] = minValue;
        }

        // System.out.println(Arrays.toString(dp));

        return dp[n-1];
    }











    Set<Integer> history = new HashSet<>();
    public int nthUglyNumber2(int n) {
        history = new HashSet<>();
        int[] ugly = new int[n];
        int i = 0;
        int num = 1;
        int uglyIndex = 0;
        for (; num < 7 && i < n; ++i) {
            ugly[uglyIndex++] = num;
            history.add(num++);
        }

        for (; i < n; ++i) {
            while (true) {
                if (this.isUgly(num)) {
                    ugly[uglyIndex++] = num;
                    history.add(num++);
                    break;
                }
                else {
                    num++;
                }
            }
        }
        // System.out.println(Arrays.toString(ugly));

        return ugly[n-1];
    }

    private boolean isUgly(int num) {
        if (num % 2 == 0) return this.isUgly(num / 2);
        else if (num % 3 == 0) return this.isUgly(num / 3);
        else if (num % 5 == 0) return this.isUgly(num / 5);
        else return history.contains(num);
    }
}
