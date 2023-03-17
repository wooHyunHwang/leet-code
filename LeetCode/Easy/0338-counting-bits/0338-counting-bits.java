class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < ans.length; ++i) {
            ans[i] = ans[i / 2] + (i % 2);
            /*
            // 죄다 계산하는 방법
            int d = i;
            while(d > 1) {
                ans[i] += d % 2;
                d /= 2;
            }
            if(d == 1) ans[i]++;
            */
        }

        return ans;
    }
}