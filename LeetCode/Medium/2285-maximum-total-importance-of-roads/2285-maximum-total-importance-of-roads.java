class Solution {
    public long maximumImportance(int n, int[][] roads) {

        int[] count = new int[n];
        int[] rank = new int[n];

        for (int[] r : roads) {
            count[r[0]]++;
            count[r[1]]++;
        }

        for (int c : count) {
            rank[c]++;
        }

        long sum = 0L;

        // for (int c : count) System.out.println(c + " === ");
        for (int i = rank.length-1; i > -1; --i) {
            // System.out.println(" === " + r);
            for (int re = 0; re < rank[i]; ++re) {
                sum += (long)i * (long)n--;
            }
        }

        return sum;
    }
    public long maximumImportance2(int n, int[][] roads) {

        // 0번 : 주소
        // 1번 : 선 갯수
        int[][] count = new int[n][2];
        for (int i = 1; i < count.length; ++i) {
            count[i][0] = i;
        }

        for (int[] r : roads) {
            count[r[0]][1]++;
            count[r[1]][1]++;
        }

        Arrays.sort(count, (o1, o2) -> o2[1] - o1[1]);

        long sum = 0L;

        for (int[] a : count) {
            // System.out.println(a[0] + " === " + a[1]);
            sum += ((long)a[1] * (long)n--);
        }

        return sum;
    }
}
// 5 4
// 4 3
// 3 2
// 2 2
// 1 1