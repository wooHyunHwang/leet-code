class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {

        int[][] answer = new int[matrix.length][matrix[0].length];
        int[] maximum = new int[matrix[0].length];
        Queue<Integer> stack = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] != -1) {
                    answer[i][j] = matrix[i][j];
                }
                else {
                    stack.add(i);
                    stack.add(j);
                }

                if (maximum[j] < matrix[i][j]) maximum[j] = matrix[i][j];
            }
        }

        while(!stack.isEmpty()) {
            int i = stack.poll();
            int j = stack.poll();

            answer[i][j] = maximum[j];
        }


        return answer;
    }
}