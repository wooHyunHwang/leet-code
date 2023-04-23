class Solution {

    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        int sum = 0;

        // 제곱인 경우, 값을 미리 더함
        int sqrt = (int)Math.sqrt(num);

        // 제곱 아래 값인 경우, 나눠진 숫자까지 더함
        for(int i = 1; i <= sqrt; ++i) {
            if (num % i == 0) {
                sum += i;
                if(i != 1) {
                    if (i == sqrt && sqrt * sqrt == num) {
                        continue;
                    }
                    sum += (num / i);
                }
                System.out.println(i + " ===");
            }
        }
        System.out.println(sum);

        return num == sum;
    }

    // brute force
    public boolean checkPerfectNumber2(int num) {
        int sum = 0;

        for(int i = num / 2; i >= 1; --i) {
            if (num % i == 0) sum += i;
        }

        return num == sum;

    }
}