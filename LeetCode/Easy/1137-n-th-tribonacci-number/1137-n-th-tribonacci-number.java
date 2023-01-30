class Solution {
    public int tribonacci(int n) {

        // int 교체 방식, 공간 복잡도 효율 ↑

        int 일 = 0;
        int 이 = 1;
        int 삼 = 1;

        if (n == 0) return 0;
        if (n <= 2) return 1;

        for (int i = 3; i <= n; ++i) {
            int 임시 = 일 + 이 + 삼;

            일 = 이;
            이 = 삼;
            삼 = 임시;
        }

        return 삼;

        /* 배열 방식
        int[] tri;

        if (n <= 2) {
            tri = new int[3];
        } else {
            tri = new int[n+1];
        }
        

        tri[0] = 0;
        tri[1] = 1;
        tri[2] = 1;

        if(n <= 2) return tri[n];

        for (int i = 3; i <= n; ++i) {
            tri[i] = tri[i - 1] + tri[i - 2] + tri[i - 3];
        }

        return tri[n];
        */

        // n = (n+3) - (n+1) - (n+2)
    }
}