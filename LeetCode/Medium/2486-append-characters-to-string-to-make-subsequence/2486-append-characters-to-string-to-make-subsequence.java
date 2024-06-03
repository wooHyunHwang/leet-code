class Solution {
    public int appendCharacters(String s, String t) {

        // 1ms 보나스
        if (s.equals(t)) return 0;

        char[] sAry = s.toCharArray();
        char[] tAry = t.toCharArray();
        int j = 0;

        int sLen = sAry.length;
        int tLen = tAry.length;

        for (int i = 0; i < sLen; ++i) {
            if (sAry[i] == tAry[j]) {
                j++;
                if (j == tLen) return 0;
            }
        }

        return tLen - j;
    }
} 