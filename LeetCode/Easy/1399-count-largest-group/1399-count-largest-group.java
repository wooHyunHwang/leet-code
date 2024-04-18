class Solution {
    public int countLargestGroup(int n) {

        int[] his = new int[37];

        for (int i = 1; i <= n; ++i) {
            int no = i;
            int sum = 0;
            while(no != 0) {
                sum += no % 10;
                no /= 10;
            }
            his[sum]++;
        }

        int max = 0;
        int same = 0;

        for (int a : his) {
            if (a > max) {
                max = a;
                same = 1;
            } else if (a == max) {
                same++;
            }
        }

        return same;
    }
}
