class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int sum = 0;
        int clockDirectionDistance = 0;

        if (destination < start) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        for (int i = 0; i < distance.length; ++i) {

            sum += distance[i];

            if (start <= i && i < destination) clockDirectionDistance += distance[i];
        }
        
        return Math.min(clockDirectionDistance, sum - clockDirectionDistance);
    }
}