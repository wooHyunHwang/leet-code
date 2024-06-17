class Solution {
    public boolean judgeSquareSum(int c) {
        for (long left = 0L; left * left <= c; ++left) {
            double d = Math.sqrt(c - left * left);
            // System.out.println(d);
            if (d == (int)d) return true;
        }

        return false;
    }
    public boolean judgeSquareSum2(int c) {
        if (c < 4) return false;
        int right = (int)Math.sqrt(c);
        int[] leftTable = new int[right+1];
        // System.out.println((int)Math.sqrt(Integer.MAX_VALUE));
        // System.out.println(this.sqrt((int)Math.sqrt(Integer.MAX_VALUE)));
        // System.out.println(Integer.MAX_VALUE);

        while (1 < right) {
            int rightPow = this.pow(right);

            for (int left = 0; left < right; ++left) {

                if (leftTable[left] == 0) leftTable[left] = this.pow(left);

                int sum = leftTable[left] + rightPow;

                //System.out.println(sum);

                if (c < sum) break;
                else if (c == sum) return true;
            }


            right--;
        }


        return false;
    }

    private int pow(int s) {
        return s*s;
    }
}