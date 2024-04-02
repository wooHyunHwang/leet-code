class Solution {
    public int maxDepth(String s) {

        int depth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                if (depth > maxDepth) maxDepth = depth;
            }
            else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}