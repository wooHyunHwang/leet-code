class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int length = piles.length;
        int start = 1;
        int end = piles[length - 1];

        while(start < end) {
            int k = (start + end) / 2;
            int sum = 0;

            for(int i = 0; i < length; ++i) {
                sum += Math.ceil((double)piles[i]/k);

                if(sum > h) {
                    start = k + 1;
                    break;
                }
            }
            if(sum <= h) {
                end = k;
            }

        }

        return start;
        
    }
}