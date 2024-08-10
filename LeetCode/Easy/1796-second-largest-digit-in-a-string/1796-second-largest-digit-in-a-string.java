class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;

        for (char c : s.toCharArray()) {
            if (c < 58) {
                
                int cInt = c - '0';
                if (cInt > first) {
                    second = first;
                    first = cInt;
                }
                else if (cInt != first && cInt > second) {
                    second = cInt;
                }
            }
        }

        return second;
    }
    public int secondHighest2(String s) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            if (c < 58) {
                
                int cInt = c - '0';
                if (cInt < first) {
                    second = first;
                    first = cInt;
                }
                else if (cInt != first && cInt < second) {
                    second = cInt;
                }
            }
        }

        return second == Integer.MAX_VALUE ? -1 : second;
    }
}