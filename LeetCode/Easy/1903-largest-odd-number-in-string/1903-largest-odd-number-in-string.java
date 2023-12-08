class Solution {
    public String largestOddNumber(String num) {
        
        // char[] nc = num.toCharArray();

        for (int i = num.length()-1; i >= 0; --i) {
            // if (nc[i] % 2 == 1) {
            if (num.charAt(i) % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}