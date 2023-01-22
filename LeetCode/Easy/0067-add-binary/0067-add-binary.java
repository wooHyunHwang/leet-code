class Solution {
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        int aLen = a.length();
        int bLen = b.length();

        int len = aLen;
        if (len < bLen) {
            len = bLen;
        }
        
        // System.out.println('0' + '0'); = 96
        // System.out.println('1' + '0'); = 97
        // System.out.println('1' + '1'); = 98

        StringBuilder sb = new StringBuilder();

        boolean up = false;

        for (int i = 0; i <= len; ++i) {

            if(i == len) {
                if (up) sb.append("1");
                break;
            }

            char addA = i < aLen ? ac[aLen - 1 - i] : '0';
            char addB = i < bLen ? bc[bLen - 1 - i] : '0';

            int added = (int)(addA + addB);

            if(added == 96) {
                if(up) {
                    sb.append("1");
                    up = false;
                } else {
                    sb.append("0");
                }
            } else if (added == 97) {
                if(up) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                if(up) {
                    sb.append("1");
                    up = true;
                } else {
                    sb.append("0");
                    up = true;
                }
            }
        }

        sb.reverse();

        return sb.toString();
    }
}