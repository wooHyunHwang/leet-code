class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        this.quickSort(names, heights, 0, heights.length-1);
        // System.out.println(Arrays.toString(heights));
        // System.out.println(Arrays.toString(heights));
        return names;
    }

    private void quickSort(String[] names, int[] heights , int left, int right) {
        if (left < right) {
            int pivot = partition(names, heights, left, right);

            quickSort(names, heights, left, pivot-1);
            quickSort(names, heights, pivot+1, right);
        }
    }

    private int partition(String[] names, int[] heights, int left, int right) {
        int low = left;
        int high = right;
        int pivot = heights[left];

        // 이번 회차 좌,우에서 좁혀지면서 피벗값의 크기를 기준으로 정렬
        do {

            while (low <= right && heights[low] >= pivot) {
                low++;
            }
            while (high >= left && heights[high] < pivot) {
                high--;
            }

            if (low < high) swap(names, heights, low, high);

        } while (low < high);

        swap(names, heights, left, high);

        return high;
    }

    /**
     * Swap
     * @param i i
     * @param j j
     */
    private static void swap(String[] names, int[] heights, int i, int j) {
        String s = names[i];
        names[i] = names[j];
        names[j] = s;

        int h = heights[i];
        heights[i] = heights[j];
        heights[j] = h;
    }
}