class Solution {
    public int maxCount(int m, int n, int[][] ops) {

        if(ops.length == 0) return m * n;

        int leftMin = m;
        int rightMin = n;
        
        for(int i = 0; i < ops.length; ++i) {
            leftMin = Math.min(leftMin, ops[i][0]);
            rightMin = Math.min(rightMin, ops[i][1]);
        }

        return leftMin * rightMin;
    }
}