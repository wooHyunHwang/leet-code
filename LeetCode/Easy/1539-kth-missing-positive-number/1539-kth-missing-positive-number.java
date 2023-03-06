class Solution {
    public int findKthPositive(int[] arr, int k) {

        if (arr.length == 0) return 0;
        
        int findCount = 0;
        int start = 0;

        for (int i = 0; i < arr.length; ++i) {
            // printProcess(findCount, start, arr[i]);
            if (findCount + (arr[i] - start) > k ) {
                // 이번 회차의 사이 값에 정답이 존재
                return (k - findCount) + start;

            } else {
                //정답이 존재하지 않아 다음 회차로
                findCount += (arr[i] - start) - 1;
                start = arr[i];
                
            }
        }

        return k - findCount + arr[arr.length - 1];
    }

    void printProcess(int findCount, int start, int arr) {
        System.out.print(findCount);
        System.out.print(" - ");
        System.out.print(start);
        System.out.print(" - ");
        System.out.print(arr);
        System.out.print(" = ");
        System.out.print(findCount + (arr - start));
        System.out.println();
    }
}