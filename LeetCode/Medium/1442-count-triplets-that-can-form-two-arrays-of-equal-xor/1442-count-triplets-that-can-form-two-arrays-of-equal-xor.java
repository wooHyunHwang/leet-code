class Solution {
    public int countTriplets(int[] arr) {
        int[][] xorResult = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; ++i) {
            xorResult[i][i] = arr[i];
            //System.out.println(i + ", " + i + " : " + xorResult[i][i]);
            for (int j = i+1; j < arr.length; ++j) {
                xorResult[i][j] = xorResult[i][j-1] ^ arr[j];
                //System.out.println(i + ", " + j + " : " + xorResult[i][j]);
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i+1; j < arr.length; ++j) {
                for (int k = j; k < arr.length; ++k) {
                    if (xorResult[i][j-1] == xorResult[j][k]) {
                        //System.out.println(i + ", " + j + ", " + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}