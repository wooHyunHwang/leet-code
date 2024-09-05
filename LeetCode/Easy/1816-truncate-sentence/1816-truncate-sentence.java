class Solution {
    public String truncateSentence(String s, int k) {

        int i = 0;
        char[] cary = s.toCharArray();

        for (; i < cary.length; ++i) {
            if (cary[i] == ' ') {
                k--;
                if (k == 0) break;
            }
        }

        return s.substring(0, i);
    }
}