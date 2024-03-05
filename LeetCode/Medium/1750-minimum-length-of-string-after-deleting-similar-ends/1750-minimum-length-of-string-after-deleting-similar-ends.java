class Solution {
    public int minimumLength(String s) {
        char[] cAry = s.toCharArray();
        int l = 0;
        int r = cAry.length - 1;

        while (l < r) {

            if (cAry[l] != cAry[r]) break;
            // System.out.println(l + " 시 " + r);
            for (; l < r;) {
                if (cAry[l + 1] == cAry[r]) {
                    l++;
                }
                else {
                    break;
                }
                
            }

            for (; r > l;) {
                if (cAry[r - 1] == cAry[l]) {
                    r--;
                }
                else {
                    break;
                }
                
            }
            l++;
            r--;
        }

        int ans = r - l + 1;
        return ans == -1 ? 0 : ans;
    }
}