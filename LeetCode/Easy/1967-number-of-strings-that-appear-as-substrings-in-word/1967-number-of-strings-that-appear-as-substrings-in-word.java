class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        char[] cw = word.toCharArray();
        for (String s : patterns) ans += this.countPattern(cw, s.toCharArray());
        return ans;
    }

    private int countPattern(char[] refer, char[] t) {
        for (int i = 0; i < refer.length; ++i) {

            if (refer[i] == t[0]) {

                int j = i;
                for (int k = 0; k < t.length; ++k) {
                    if (j < refer.length && t[k] == refer[j++]) {
                        if (k+1 == t.length) return 1;
                    } else {
                        break;
                    }
                }

            }
        }

        /*
        if (new String(refer).indexOf(target) != -1) {
            System.out.println(target);
        }
        */

        return 0;
    }
}