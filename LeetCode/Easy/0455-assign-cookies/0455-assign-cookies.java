class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gnt = 0;
        int snt = 0;

        for (; gnt < g.length; ++gnt) {
            boolean find = false;
            for (; snt < s.length; ++snt) {
                if (g[gnt] <= s[snt]) {
                    snt++;
                    find = true;
                    break;
                }
            }
            if (!find) break;
        }
        

        return gnt;
        /*
        int i = g.length - 1, j = s.length - 1;
        int c = 0;
        while(i >= 0 && j >= 0){
            if(g[i] <= s[j]){
                j--;
                c++;
            }
            i--;
        }

        return c;
        */
    }
}