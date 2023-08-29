class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> xAxis = new HashSet<>();
        Set<Integer> yAxis = new HashSet<>();

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    xAxis.add(i);
                    yAxis.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; ++i) {
            boolean xAxisContain = xAxis.contains(i);
            for(int j = 0; j < matrix[i].length; ++j) {
                if(xAxisContain || yAxis.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}