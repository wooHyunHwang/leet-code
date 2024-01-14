class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int a2i = 0;
        int start = 0;
        
        while (a2i < arr2.length) {

            for (int i = start; i < arr1.length; ++i) {
                if (arr2[a2i] == arr1[i]) {
                    int t = arr1[i];
                    arr1[i] = arr1[start];
                    arr1[start++] = t;
                }
            }

            a2i++;
        }
        this.quickSort(arr1, start, arr1.length-1);

        return arr1;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;
        int temp;

        while (left <= right) {
            while (left < array.length && array[pivot] >= array[left]) {
                left++;
            }

            while (array[pivot] <= array[right] && right > start) {
                right--;
            }

            if (left > right) {
                temp = array[right];
                array[right] = array[start];
                array[start] = temp;
            }
            else {
                temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        this.quickSort(array, start, right - 1);
        this.quickSort(array, right + 1, end);
    }
}