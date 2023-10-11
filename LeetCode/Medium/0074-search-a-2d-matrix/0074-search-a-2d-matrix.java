class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int i = matrix.length / 2;
        int j = matrix[0].length / 2;

        // System.out.println(i + " / " + j);

        if (matrix[i][0] < target) {
            // i 위로
            int temp = i + 1;
            while(temp < matrix.length && matrix[temp][0] <= target) {
                // System.out.println("-- " + matrix[temp][0]);
                i = temp++;
            }

        } else {
            // i 아래로
            while(i >= 1 && matrix[i][0] > target) {
                i--;
            }
        }
        // System.out.println(i);

        if (matrix[i][j] == target) return true;
        else if (matrix[i][j] < target) {
            // j 오른쪽
            while(j < matrix[0].length - 1 && matrix[i][j] < target) {
                if (matrix[i][++j] == target) return true;
            }
        } else {
            // j 왼쪽
            while(j > 0 && matrix[i][j] > target) {
                if (matrix[i][--j] == target) return true;
            }
        }

        return false;



    }
}