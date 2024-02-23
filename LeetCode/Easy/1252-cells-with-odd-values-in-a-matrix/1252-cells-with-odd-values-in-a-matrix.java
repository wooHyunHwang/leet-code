class Solution {
    public int oddCells(int m, int n, int[][] indices) {

        int[] height = new int[m];
        int[] width = new int[n];
        
        for (int i = 0; i < indices.length; ++i) {
            // indices[i][0]
            // indices[i][1]
            height[indices[i][0]]++;
            width[indices[i][1]]++;
        }

        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // System.out.println((height[i] + width[j]) + " - ");
                if ((height[i] + width[j]) % 2 == 1) ans++;
            }
        }

        return ans;
    }
}