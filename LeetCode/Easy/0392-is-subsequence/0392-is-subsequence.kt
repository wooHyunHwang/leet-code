class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if(s.length == 0) return true;
        if(t.length == 0) return false;

        var idx = 0;

        for (tc in t.toCharArray()) {
            if (s[idx] == tc) {
                idx++;
                if(idx >= s.length) return true;
            }
        }
        return false;
    }
}