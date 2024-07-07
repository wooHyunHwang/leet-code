class Solution {
    public String getEncryptedString(String s, int k) {
        char[] original = s.toCharArray();
        int len = original.length;
        char[] cAry = new char[len];
        
        System.arraycopy(original, 0, cAry, 0, len);

        k = k % len;

        for (int i = 0; i < cAry.length; ++i) {
            // System.out.println(k + " /// " + len);
            cAry[i] = original[k++];
            if (k == len) k = 0;
        }

        return new String(cAry);
    }
}