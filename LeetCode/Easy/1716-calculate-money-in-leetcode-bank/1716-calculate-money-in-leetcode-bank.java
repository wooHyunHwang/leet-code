class Solution {
    public int totalMoney(int n) {

        int sum = 0;

        int weekStack = 28;
        int loop = n / 7;
        int remain = n % 7;

        for (int i = 0; i < loop; ++i) {
            if (i == 0) {
                sum += weekStack;
                continue;
            }

            weekStack += 7;
            sum += weekStack;
        }

        // System.out.println("== " + sum);

        for (int i = 0; i < remain; ++i) {
            sum += ++loop;
            // System.out.println(sum);
        }

        return sum;
    }
}