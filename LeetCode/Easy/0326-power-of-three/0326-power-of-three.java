class Solution {
    // 3의 19승, 즉 int에서 나올 수 있는
    // 3의 거듭제곱 최대값으로 구하는게 맞는걸까..
    public boolean isPowerOfThree(int n) {

        if (n <= 0) return false;

        while(n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }

        return true;

    }
}