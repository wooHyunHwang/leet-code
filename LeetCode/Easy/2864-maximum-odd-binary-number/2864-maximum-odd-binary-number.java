class Solution {
    public String maximumOddBinaryNumber(String s) {

        char[] sb = new char[s.length()];
        int oneIdx = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                sb[oneIdx++] = '1';
            }
        }
        for (int i = oneIdx; i < sb.length; ++i) {
            sb[i] = '0';
        }
        sb[--oneIdx] = '0';
        sb[sb.length-1] = '1';

        return new String(sb);
    }
}