class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<Integer[]> temp = new ArrayList<>();

        int[] temp2 = intervals[0];

        for (int i = 1; i < intervals.length; ++i) {
            if (temp2[1] < intervals[i][0]) {
                Integer[] add = new Integer[2];
                add[0] = temp2[0];
                add[1] = temp2[1];
                temp.add(add);

                temp2 = intervals[i];

            } else if (temp2[1] < intervals[i][1]) {
                temp2[1] = intervals[i][1];
            }
        }

        Integer[] add = new Integer[2];
        add[0] = temp2[0];
        add[1] = temp2[1];
        temp.add(add);

        int[][] ans = new int[temp.size()][2];

        for (int i = 0; i < ans.length; ++i) {
            ans[i][0] = temp.get(i)[0];
            ans[i][1] = temp.get(i)[1];
        }

        return ans;

    }
}