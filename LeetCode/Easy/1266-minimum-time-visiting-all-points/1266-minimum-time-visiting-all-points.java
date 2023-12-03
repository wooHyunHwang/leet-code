class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int time = 0;

        for (int i = 1; i < points.length; ++i) {

            time += this.max(
                Math.abs(points[i][0] - points[i-1][0]),
                Math.abs(points[i][1] - points[i-1][1])
            );
        }

        return time;
    }

    int max(int x, int y) {
        return x >= y ? x : y;
    }
}
