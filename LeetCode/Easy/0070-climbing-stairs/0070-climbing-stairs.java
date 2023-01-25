class Solution {
    public int climbStairs(int n) {

        // 문제 자체가 피보나치 수열
        // 1, 2, 3, 5, 8, 13
        // 0, 1, 1, 2, 3, 5, 8, 13
        // -2번 회차의 증가 값

        // 1, 2회차 무시
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 3회차 부터 계산
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for(int i = 2; i < n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }


        return arr[n - 1];
        


        /* 실패한 방식
        int ans = 0;
        int twoMax = n / 2;
        int twoCount = 0;
        
        while(twoCount <= twoMax) {
            System.out.println("-----------");
            int oneCount = n - (twoCount * 2);

            ans += ((oneCount * twoCount) + 1);

            System.out.println("one " + oneCount + " / two " + twoCount);
            System.out.println(((oneCount * twoCount) + 1));

            twoCount++;

        }

        return ans;
        */
    }

    
}