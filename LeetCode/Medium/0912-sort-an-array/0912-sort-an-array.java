class Solution {
    public int[] sortArray(int[] nums) {
        this.mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;

            // 재귀호출로 최대한 분리
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int[] merged = new int[arr.length];

        int oneI = left;
        int twoI = mid+1;
        int mergedIdx = 0;

        // 최대로 쪼갠 배열을 하나씩 비교하여 정렬
        // 쪼갠 덩어리가 전부 정렬된 상태로 만들기 위함
        while(oneI <= mid && twoI <= right) {
            if (arr[oneI] <= arr[twoI]) merged[mergedIdx++] = arr[oneI++];
            else if (arr[oneI] > arr[twoI]) merged[mergedIdx++] = arr[twoI++];
        }

        // 정렬된 값을 중 남은 값 처리
        while(oneI <= mid) merged[mergedIdx++] = arr[oneI++];
        while(twoI <= right) merged[mergedIdx++] = arr[twoI++];

        // 원본 배열에 정리된 값 적용
        System.arraycopy(merged, 0, arr, left, right-left+1);
    }
}