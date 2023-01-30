class Solution {
    public int tribonacci(int n) {
        
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

        // n = (n+3) - (n+1) - (n+2)
    }
}