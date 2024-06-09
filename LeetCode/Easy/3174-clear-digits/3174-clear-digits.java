class Solution {
    public String clearDigits(String s) {

        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if ('0' <= c && c <= '9') {
                sb.deleteCharAt(i--);
                sb.deleteCharAt(i--);
            }
        }

        return sb.toString();
    }
}