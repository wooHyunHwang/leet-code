class Solution {
    public int strStr(String haystack, String needle) {

        if (haystack.length() == 0 || needle.length() == 0) return -1;
        if (haystack.equals(needle)) return 0;

        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        for (int i = 0; i < haystackArr.length - needleArr.length + 1; ++i) {
            for (int j = 0; j < needleArr.length; ++j) {
                if (haystackArr[i + j] == needleArr[j]) {
                    if (j == needleArr.length - 1) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}