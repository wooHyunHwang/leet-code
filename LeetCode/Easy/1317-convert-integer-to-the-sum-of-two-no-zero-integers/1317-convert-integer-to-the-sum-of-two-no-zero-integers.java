class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        int b = n-1;

        ans[0] = 1;
        ans[1] = b;

        int stack = 1;

        while(b > 0) {
            if (b % 10 == 0) {
                int tempA = ans[0];
                int tempStack = stack / 10;

                ans[0] += stack;
                ans[1] -= stack;
                b -= 1;

                while (tempStack > 0) {
                    if (tempA / tempStack == 0) {
                        ans[0] += tempStack;
                        ans[1] -= tempStack;

                        if (ans[1] / tempStack % 10 == 0) {
                            ans[0] += tempStack;
                            ans[1] -= tempStack;
                        }
                    }
                    tempStack /= 10;
                }

            }
            // System.out.println(b);
            b /= 10;
            stack *= 10;
        }



        return ans;
    }
}
// 1 5011
// 101 4911
// 111 4901