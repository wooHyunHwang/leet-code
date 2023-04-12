class Solution {
    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();

        int check = 0;
        char[] sAry = s.toCharArray();

        for (int i = sAry.length - 1; i >= 0; --i) {

            if(sAry[i] != '-') {

                if (check == k) {
                    sb.append('-');
                    check = 0;
                }

                if ('a' <= sAry[i] && sAry[i] <= 'z') {
                    sb.append((char)(sAry[i] - 32));
                } else {
                    sb.append(sAry[i]);
                }
                
                check++;
            }
        }

        return sb.reverse().toString();
    }


}