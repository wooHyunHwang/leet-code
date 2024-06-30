class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        boolean[] history = new boolean[n*n+1];

        for (int[] inG : grid) {
            for (int g : inG) {
                if (history[g]) {
                    ans[0] = g;
                }
                else {
                    history[g] = true;
                }
            }
        }

        for(int i = 1; i < history.length; ++i) {
            if (!history[i]) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}