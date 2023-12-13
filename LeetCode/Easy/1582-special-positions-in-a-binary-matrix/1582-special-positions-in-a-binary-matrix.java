class Solution {
    public int numSpecial(int[][] mat) {

        int count = 0;

        for (int i = 0; i < mat.length; ++i) {
            int findM = this.checkM(mat, i);
            if (findM != -1 && this.checkN(mat, i, findM)) count++;
        }

        return count;
    }

    private int checkM(int[][] mat, int i) {
        int findM = -1;
        for (int j = 0; j < mat[i].length; ++j) {
            if (mat[i][j] == 1) {
                if (findM != -1) return -1;
                else findM = j;
            }
        }
        return findM;
    }

    private boolean checkN(int[][] mat, int i, int findM) {
        for (int j = 0; j < mat.length; ++j) {
            if (mat[j][findM] == 1 && i != j) return false;
        }
        return true;
    }





    public int numSpecial2(int[][] mat) {

        int count = 0;

        for (int i = 0; i < mat.length; ++i) {
            int findM = -1;
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 1) {

                    if (findM != -1) {
                        findM = -1;
                        break;
                    }
                    else {
                        findM = j;
                    }
                }
            }

            if (findM != -1) {
                int findN = -1;
                for (int k = 0; k < mat.length; ++k) {
                    if (mat[k][findM] == 1) {

                        if (findN != -1) {
                            findN = -1;
                            break;
                        }
                        else {
                            findN = k;
                        }
                    }
                }
                if (findN != -1) {
                    count++;
                }
            }
        }

        return count;
    }
    // n + 2n*m
    public int numSpecial1(int[][] mat) {
        
        int count = 0;
        int[] history = new int[mat.length]; // -1이 초기값
        // n
        Arrays.fill(history, -1);

        // n * m
        for (int i = 0; i < mat.length; ++i) {
            int find = -1;
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 1) {

                    if (find != -1) {
                        find = -1;
                        break;
                    }
                    else {
                        find = j;
                    }
                }
            }
            if (find != -1) history[i] = find;
        }

        // n * m
        for (int j = 0; j < mat[0].length; ++j) {
            int find = -1;
            for (int i = 0; i < mat.length; ++i) {
                if (mat[i][j] == 1) {

                    if (find != -1) {
                        find = -1;
                        break;
                    }
                    else {
                        find = i;
                    }
                }
            }
            if (find != -1 && history[find] != -1) {
                count++;
            }
        }
        return count;
    }
}