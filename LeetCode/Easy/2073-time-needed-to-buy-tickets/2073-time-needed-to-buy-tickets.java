class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {

        int kValue = tickets[k];
        int count = 0;

        for (int i = 0; i < tickets.length; ++i) {

            if(tickets[i] >= kValue) {
                if(i <= k) count += kValue;
                else count += kValue-1;
            }
            else {
                count += tickets[i];
            }
        }
        return count;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        
        int count = 0;

        for (int i = 0; i < tickets.length; ++i) {
            if (tickets[i] > 0) {
                tickets[i]--;
                count++;
            }
            if (i == k && tickets[i] == 0) return count;
            else if (i == tickets.length-1) {
                i = -1;
            }
        }

        return -1;
    }
}