class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {

        int ret = 0;

        int[] dp = new int[2000];
        int lastDp = 0;
        boolean[][] map = new boolean[10][10];
        int[][] ans = new int[10][10];

        for (int[] domino : dominoes) {
            if (map[domino[0]][domino[1]] || map[domino[1]][domino[0]]) {
                if (domino[1] > domino[0]) {
                    ans[domino[0]][domino[1]]++;
                }
                else {
                    ans[domino[1]][domino[0]]++;
                }
                
            }
            map[domino[0]][domino[1]] = true;
            map[domino[1]][domino[0]] = true;
        }

        for (int[] a : ans) {
            for (int aCount : a) {
                if (aCount > 0) {
                    // System.out.println(aCount);
                    if (dp[aCount] > 0) {
                        ret += dp[aCount];
                    }
                    else {
                        for (int i = lastDp+1; i <= aCount; ++i) {
                            dp[i] = i + dp[i-1];
                        }
                        ret += dp[aCount];
                    }

                }
            }
        }

        return ret;
    }
}

// 1,2
// 1 2 3 4  5
// 1 3 6 10 15