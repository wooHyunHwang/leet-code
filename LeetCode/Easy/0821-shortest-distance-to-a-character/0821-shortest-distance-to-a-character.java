class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] cAry = s.toCharArray();
        int[] ans = new int[cAry.length];

        int before = 10_000;

        // 첫번째 idx 탐색
        for(int i = 0; i < cAry.length; ++i) {

            // 기본 : 이전 찾은값과 비교
            if(cAry[i] != c) {
                ans[i] = Math.abs(before - i);
                continue;
            }

            // 대상 찾을 경우 역행해서 기록
            before = i;
            ans[i] = 0;

            int reverse = i - 1;
            int distance = 1;
            while(reverse >= 0) {

                if(distance < ans[reverse]) ans[reverse--] = distance++;
                else break;
            }
        }

        return ans;
        


    }
}