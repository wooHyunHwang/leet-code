class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        if(mat.length * mat[0].length != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];

        int x = 0, y = 0;

        r--;
        c--;

        for(int m = 0; m < mat.length; ++m) {
            for(int n = 0; n < mat[m].length; ++n) {
                ans[x][y] = mat[m][n];

                if(y != c) {
                    y++;
                } else {
                    x++;
                    y = 0;
                }
            }
        }

        return ans;
    }
}