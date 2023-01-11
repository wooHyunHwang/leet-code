class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, Comparator.comparingInt(o1 -> o1[1]));

        int arrowCount = 1;
        int startIndex = 0;
        int deleteCount = 0;
        
        for( int i = 1; i <= points.length - 1 ; ++i ) {
            if (points[startIndex][1] >= points[i][0]) {
                deleteCount++;
            } else {
                arrowCount++;
                startIndex = i;
            }
        }
        return arrowCount;
    }
}