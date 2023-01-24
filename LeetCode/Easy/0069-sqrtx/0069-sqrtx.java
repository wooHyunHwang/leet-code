class Solution {
    public int mySqrt(int x) {
        
        if (x == 0) return x;

        int start = 1;
        int end = x;

        // start, end의 중간값 탐색
        while(start <= end) {
            int mid = start + ((end - start) / 2);
            int compare = x / mid;

            if(mid == compare) {
                // int 나머지 버림 처리로 자동으로 제곱근으로 판단
                return mid;
            } else if (mid <= compare) {
                // 중간값 보다 크다는건 가장 가까운 루트값보다 작았다는 의미
                // 다음 루틴시 시작 값 증가
                start = mid + 1;
            } else {
                // 중간값 보다 작다는건 가장 가까운 루트값보다 크다는 의미
                // 다음 루틴시 종료 값 감소
                end = mid - 1;
            }
        }

        return end;
    }

}