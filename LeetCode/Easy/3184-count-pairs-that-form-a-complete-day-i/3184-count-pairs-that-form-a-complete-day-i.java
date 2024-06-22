class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;
        for (int hour : hours) {
            int remainder = hour % 24;
            if (remainder == 0) {
                count += remainderCount.getOrDefault(0, 0);
            } else {
                count += remainderCount.getOrDefault(24 - remainder, 0);
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}
