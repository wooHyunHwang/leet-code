class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxIdx = difficulty.length-1;
        // 정렬
        this.multiQuickSort(difficulty, profit, 0, maxIdx);
        Arrays.sort(worker);

        for (int i = 1; i < profit.length; ++i) {
            if (profit[i-1] > profit[i]) profit[i] = profit[i-1];
        }

        // IDX, FOR
        int idx = 0;
        int ans = 0;
        for (int w : worker) {
            while(idx < maxIdx) {
                if (difficulty[idx+1] <= w) idx++;
                else break;
            }
            // System.out.println(profit[idx]);
            if (difficulty[idx] <= w) ans += profit[idx];
        }
        return ans;
    }

    private void multiQuickSort(int[] arr, int[] mirror, int left, int right) {
        if (left < right) {

            // 분할한 영역을 정렬, Pivot 위치 리턴
            int pivot = multiQuickSortPartition(arr, mirror, left, right);

            // q 기준으로 다시 Left/Right quickSort 진행
            multiQuickSort(arr, mirror, left, pivot-1);
            multiQuickSort(arr, mirror, pivot+1, right);

        }
    }
    private int multiQuickSortPartition(int[] arr, int[] mirror, int left, int right) {
        int low = left;
        int high = right+1;
        int pivot = arr[left];

        // 이번 회차 좌,우에서 좁혀지면서 피벗값의 크기를 기준으로 정렬
        do {

            do { low++; }
            while (low <= right && arr[low] < pivot);
            do { high--; }
            while (high >= left && arr[high] > pivot);

            if (low < high) swap(arr, mirror, low, high);

        } while (low < high);

        swap(arr, mirror, left, high);

        return high;
    }
    private void swap(int[] arr, int[] arr2, int i, int j) {
        int val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;

        val = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = val;
    }
}
// 35 47 52 68 86
// 17 81 1  67 3