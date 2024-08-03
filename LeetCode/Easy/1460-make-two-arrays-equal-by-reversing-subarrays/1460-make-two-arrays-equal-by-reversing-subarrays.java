class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int count = 0;
        int[] his = new int[1_001];

        for (int t : target) {
            if (his[t] == 0) count++;
            his[t]++;
        }
        for (int a : arr) {
            his[a]--;
            if (his[a] == 0) count--;
        }

        return count == 0;
    }
}