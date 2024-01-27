class Solution {
    public int[] arrayRankTransform(int[] arr) {

        if (arr.length == 0) return new int[0];

        int[] ans = new int[arr.length];
        int[] sort = new int[arr.length];

        System.arraycopy(arr, 0, sort, 0, arr.length);
        Arrays.sort(sort);

        int count = 2;
        Map<Integer, Integer> rank = new HashMap<>();

        rank.put(sort[0], 1);

        for (int i = 1; i < sort.length; ++i) {
            if (sort[i] != sort[i-1]) {
                rank.put(sort[i], count++);
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            ans[i] = rank.get(arr[i]);
        }

        return ans;
    }
}