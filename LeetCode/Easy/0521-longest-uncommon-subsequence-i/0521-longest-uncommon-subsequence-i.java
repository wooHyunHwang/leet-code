class Solution {
    public int findLUSlength(String a, String b) {
        if(b.equals(a)) return -1;
        return Math.max(a.length(), b.length());
    }
}