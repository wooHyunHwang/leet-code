class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] dic = new int[26];
        for (char c : text.toCharArray()) dic[c-'a']++;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, dic[0]);
        min = Math.min(min, dic[1]);
        min = Math.min(min, dic[11]/2);
        min = Math.min(min, dic[13]);
        min = Math.min(min, dic[14]/2);
        return min;
    }
}