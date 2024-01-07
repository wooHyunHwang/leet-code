class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;

        for (int[] rectangle : dimensions) {
            int diagonal = rectangle[0] * rectangle[0] + rectangle[1] * rectangle[1];
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = rectangle[0] * rectangle[1];
            }
            else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, rectangle[0] * rectangle[1]);
            }
        }

        return maxArea;
    }
}