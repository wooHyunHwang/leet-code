class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        
        int[] array = new int[points.length];

        for (int i = 0; i < points.length; ++i) {
            array[i] = points[i][0];
        }

        Arrays.sort(array);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; ++i) {
            max = Math.max(max, array[i] - array[i-1]);
        }

        return max;
    }
}