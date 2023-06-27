class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] arr = new int[nums1.length][2];

        for(int i = 0 ; i < nums1.length; ++i) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        long ans = 0;
        long sum = 0;
        for(int[] pair : arr) {

            pq.add(pair[0]);
            sum += pair[0];

            if(pq.size() > k) {
                sum -= pq.poll();
            }

            if(pq.size() == k) {
                ans = Math.max(ans, sum * pair[1]);
            }
        }

        return ans;


    }
}

