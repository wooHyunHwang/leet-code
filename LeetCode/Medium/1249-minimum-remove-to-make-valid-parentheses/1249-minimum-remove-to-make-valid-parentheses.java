class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();
        char[] cAry = s.toCharArray();
        int count = 0;

        for (int i = 0; i < cAry.length; ++i) {
            if (cAry[i] == '(') {
                count++;
            }
            else if (cAry[i] == ')') {
                if (count == 0) {
                    cAry[i] = '\u0000';
                    continue;
                }
                count--;
            }
        }

        for (int i = cAry.length-1; i > -1; --i) {
            if (cAry[i] == '\u0000') {
                continue;
            }
            if (count > 0 && cAry[i] == '(') {
                count--;
                cAry[i] = '\u0000';
                continue;
            }
            sb.append(cAry[i]);
        }

        sb.reverse();

        return sb.toString();
    }
}