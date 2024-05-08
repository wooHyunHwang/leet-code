class Solution {
    public int countOperations(int num1, int num2) {
        int count = 0;

        while (num1 != 0 && num2 != 0) {

            if (num1 > num2) {
                count += num1 / num2;
                num1 %= num2;
            }
            else {
                count += num2 / num1;
                num2 %= num1;
            }
        }

        return count;
    }

    public int countOperations2(int num1, int num2) {
        return countOperations2(num1, num2, 0);
    }

    private int countOperations2(int num1, int num2, int stack) {
        if (num1 == 0 || num2 == 0) return stack;

        if (num1 < num2) return this.countOperations2(num1, num2 - num1, stack+1);
        else return this.countOperations2(num1 - num2, num2, stack+1);
    }
}