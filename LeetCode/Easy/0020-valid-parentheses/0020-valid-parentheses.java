class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) return false;

        int len = s.length();

        while(len != 0) {
            s = s.replaceAll("\\{\\}|\\(\\)|\\[\\]", "");


            if (len == s.length()) {
                return false;
            }
            len = s.length();
            if (len % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}