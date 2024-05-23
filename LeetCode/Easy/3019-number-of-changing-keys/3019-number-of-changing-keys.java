class Solution {
    private final int div = 32;
    public int countKeyChanges(String s) {

        int ans = 0;
        char[] cAry = s.toCharArray();
        int beforeUpperCase = cAry[0] >= 'a' ? cAry[0] - div : cAry[0];

        for (int i = 1; i < cAry.length; ++i) {
            int nextUpperCase = cAry[i] >= 'a' ? cAry[i] - div : cAry[i];
            if (beforeUpperCase != nextUpperCase) ans++;
            // System.out.println(beforeUpperCase + " + " + nextUpperCase);
            beforeUpperCase = nextUpperCase; 
        }  

        return ans;
    }
}