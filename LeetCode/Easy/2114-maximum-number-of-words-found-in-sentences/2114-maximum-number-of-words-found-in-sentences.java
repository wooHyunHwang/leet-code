class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String str : sentences) {
            int len = this.countSentence(str);
            if (max < len) max = len;
        }
        return max;
    }
    private int countSentence(String sentence) {
        int count = 1;
        for (char c : sentence.toCharArray()) {
            if (c == ' ') count++;
        }
        return count;
    }
}