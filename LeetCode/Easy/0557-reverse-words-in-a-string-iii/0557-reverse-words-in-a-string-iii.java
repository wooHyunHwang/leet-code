class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        String[] sAry = s.split(" ");
        
        for(int j = 0; j < sAry.length; ++j) {
            char[] cAry = sAry[j].toCharArray();

            for(int i = cAry.length - 1; i >= 0; --i) {
                sb.append(cAry[i]);
            }
            if(j != sAry.length - 1) sb.append(" ");
        }

        return sb.toString();
    }
}