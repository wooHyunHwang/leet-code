class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);

        int score = 0;
        int maxScore = 0;
        int l = 0;
        int r = tokens.length-1;

        while (l <= r) {
            // LEFT
            if (tokens[l] <= power) {
                power -= tokens[l++];
                score++;
                if (maxScore < score) maxScore = score;
            }
            // RIGHT
            else if (score > 0) {
                power += tokens[r--];
                score--;
            }
            else {
                break;
            }
        }

        return maxScore;
    }
}