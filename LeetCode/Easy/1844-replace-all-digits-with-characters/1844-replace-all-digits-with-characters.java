class Solution {
    public String replaceDigits(String s) {
        char[] cAry = s.toCharArray();
        for (int i = 1; i < cAry.length; i += 2) {
            cAry[i] = (char)(cAry[i-1] + cAry[i] - '0');
        }
        return new String(cAry);
    }
}