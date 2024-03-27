class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if ("../".equals(log)) {
                if (depth > 0) depth--;
            }
            else if (!"./".equals(log)) {
                depth++;
            }
        }

        return depth;
    }
}