class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int ones = 0;
        int tmpScore = s.charAt(0) == '0' ? 1 : 0;
        int score = tmpScore;
        for (int i = 1; i < len - 1; i++) {
            if (s.charAt(i) == '0') {
                tmpScore++;
            } else {
                ones++;
                tmpScore--;
            }

            if (tmpScore > score) {
                score = tmpScore;
            }
        }
        if (s.charAt(len - 1) == '1') ones++;

        return ones + score;
    }
    
    public int maxScore2(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        for ( int i = 0; i < s.length(); ++i ) {
            if (s.charAt(i) == '1') right++;
        }

        for ( int i = 0; i < s.length()-1; ++i ) {
            if (s.charAt(i) == '0') left++;
            else right--;

            max = Math.max(max, left + right);
        }

        return max;
    }
}