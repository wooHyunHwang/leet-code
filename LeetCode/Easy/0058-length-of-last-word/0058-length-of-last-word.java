class Solution {
    public int lengthOfLastWord(String s) {

        String trim = s.trim();

        return trim.substring(
            trim.lastIndexOf(" ") + 1
        ).length();
    }
}