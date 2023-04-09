class Solution {
    // 비트 연산자로 해결
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

    // 모든 비트 직접 비교
    public int hammingDistance2(int x, int y) {
        char[] xArr = Integer.toBinaryString(x).toCharArray();
        char[] yArr = Integer.toBinaryString(y).toCharArray();
        
        int ans = 0;
        int min = Math.min(xArr.length, yArr.length);
        int max = Math.max(xArr.length, yArr.length);

        for(int i = 0; i < max; ++i) {
            
            if (i < min) {

                // 공통 index 부분 비교
                if (xArr[xArr.length - i - 1] != yArr[yArr.length - i - 1]) {
                    // 같지 않음
                    ans++;
                }

            } else {
                // 높은 숫자쪽 남은 index 확인
                if (xArr.length > yArr.length && xArr[xArr.length - i - 1] == '1') {
                    // x가 큰 경우
                    ans++;
                } else if (xArr.length < yArr.length && yArr[yArr.length - i - 1] == '1') {
                    // y가 큰 경우
                    ans++;
                }
            }

        }
        return ans;
    }
}