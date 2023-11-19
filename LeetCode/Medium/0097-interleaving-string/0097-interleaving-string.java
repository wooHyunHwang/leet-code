class Solution {

    private boolean[][] dp = null;

    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length() + s2.length() != s3.length()) return false;

        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        char[] sc3 = s3.toCharArray();

        dp = new boolean[sc1.length][sc2.length];

        return this.recursive(sc1, sc2, sc3, 0, 0, 0);   
    }

    private boolean recursive(char[] sc1, char[] sc2, char[] sc3, int index, int i, int j) {
        
        if (index >= sc3.length) return true;
        if (i < sc1.length && j < sc2.length && dp[i][j]) return false;

        if (i < sc1.length && j < sc2.length && sc1[i] == sc2[j] && sc1[i] == sc3[index]) {
            // 가지 생성
            if (this.recursive(sc1, sc2, sc3, index + 1, i + 1, j)) {
                return true;
            }
            if (this.recursive(sc1, sc2, sc3, index + 1, i, j + 1)) {
                return true;
            }

            dp[i][j] = true;
            return false;

        } else {
            // 직진
            if (i < sc1.length && sc1[i] == sc3[index]) i++;
            else if (j < sc2.length && sc2[j] == sc3[index]) j++;
            else {
                if (i < sc1.length && j < sc2.length) dp[i][j] = true;
                return false;
            }

            return this.recursive(sc1, sc2, sc3, index + 1, i, j);
        }
    }
}
// a a d b b c b c a c
// 
// $ a a b c c
// d 1 2 
// b   3
// b   4
// c   5 6 7
// a       8 9
