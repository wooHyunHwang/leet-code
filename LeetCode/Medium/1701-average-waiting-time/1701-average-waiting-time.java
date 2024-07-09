class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double currentTime = customers[0][0];
        double lastCookTime = customers[0][0];
        double waiting = 0;

        for (int[] customer : customers) {
            double time = 0;
            if (customer[0] > lastCookTime) {
                // 도착시간까지 여유 시간이 발생
                time = customer[1];
                lastCookTime = customer[0] + customer[1];
            }
            else {
                // 요리중이어서 대기해야함
                time = lastCookTime - customer[0] + customer[1];
                lastCookTime += customer[1];
            }
            waiting += time;
        }

        return waiting / customers.length;
    }
}