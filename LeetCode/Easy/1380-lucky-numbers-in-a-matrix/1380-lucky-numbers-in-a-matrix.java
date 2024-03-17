class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; ++i) {
            int min = matrix[i][0];
            int minIdx = 0;
            for (int j = 1; j < matrix[i].length; ++j) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    minIdx = j;
                }
            }

            boolean find = true;
            for (int k = 0; k < matrix.length; ++k) {
                if (min < matrix[k][minIdx]) {
                    find = false;
                    break;
                }
            }
            if (find) ans.add(min);
        }

        return ans;
    }

    public List<Integer> luckyNumbers2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // 가로 (최소)
        int[] row = new int[matrix.length];
        // 세로 (최대)
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            row[i] = matrix[i][0];
            for (int j = 0; j < matrix[i].length; ++j) {
                if (row[i] > matrix[i][j]) row[i] = matrix[i][j];
                if (i == 0) col[j] = matrix[i][j];
                else {
                    if (col[j] < matrix[i][j]) col[j] = matrix[i][j];
                }
            }
        }

        boolean[] his = new boolean[100_001];
        for (int r : row) {
            // System.out.print(r + " - ");
            his[r] = true;
        }
        // System.out.println();
        for (int c : col) {
            // System.out.print(c + " - ");
            if (his[c]) ans.add(c);
        }

        return ans;
    }
}
