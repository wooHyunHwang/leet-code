class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;

        for (int i = 0; i < batteryPercentages.length; ++i) {
            batteryPercentages[i] -= count;
            if (batteryPercentages[i] > 0) {
                count++;
            }
        }

        return count;
    }
}