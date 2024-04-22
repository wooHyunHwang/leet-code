class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        char[] sChar = s.toCharArray();

        for (int pre = 0, i = 1; i < sChar.length;) {
            score += Math.abs((int)(sChar[i++] - sChar[pre++]));
        }

        return score;
    }
}