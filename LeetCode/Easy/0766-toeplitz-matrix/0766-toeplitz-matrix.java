class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int width = matrix[0].length;
        int height = matrix.length;

        // System.out.println("가로");
        for(int i = 0; i < width; ++i) {
            int start = matrix[0][i];

            for(int j = 1; j < height; ++j) {
                /*
                if(i + j < width) {
                    System.out.println("j : " + j + " / s : " + (j + i));
                    System.out.println("start : " + start + " / matrix : " + matrix[j][i + j]);
                }
                */
                if(i + j < width && start != matrix[j][i + j]) return false;;
            }
        }

        // System.out.println("세로");
        for(int j = 1; j < height; ++j) {
            int start = matrix[j][0];

            for(int i = 1; i < width; ++i) {
                /*
                if(i + j < height) {
                    System.out.println("j : " + j + " / s : " + (j + i));
                    System.out.println("start : " + start + " / matrix : " + matrix[i + j][i]);
                }
                */
                if(i + j < height && start != matrix[i + j][i]) return false;;
            }
        }

        return true;
    }
}