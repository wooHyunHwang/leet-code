class Solution {
    public boolean isSubsequence(String s, String t) {

        if(s.length() == 0) return true;
        if(t.length() == 0) return false;

        int idx = 0;
        char[] sc = s.toCharArray();

        for (char tc : t.toCharArray()) {
            if (sc[idx] == tc) {
                idx++;
                if (idx >= sc.length) return true;
            }
        }
        return false;
    }
}