class Solution {
    public int findCenter(int[][] edges) {

        int[] ary1 = edges[0];
        int[] ary2 = edges[1];

        for (int a1 : ary1) {
            for (int a2 : ary2) {
                if (a1 == a2) return a1;
            }
        }

        return -1;
    }
    public int findCenter2(int[][] edges) {

        int max = 0;
        int i = 0;
        int[] ary = new int[edges.length+2];

        for (int[] ed : edges) {
            for (int e : ed) {
                ary[e]++;
                if (max < ary[e]) {
                    max = ary[e];
                    i = e;
                }
            }
        }

        return i;
    }
}