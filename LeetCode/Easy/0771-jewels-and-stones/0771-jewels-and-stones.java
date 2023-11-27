class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int count = 0;
        char[] jewel = jewels.toCharArray();
        char[] stone = stones.toCharArray();
        boolean[] dict = new boolean[58];

        for (char c : jewel) {
            dict[c - 65] = true;
        }

        for (char s : stone) {
            if (dict[s - 65]) count++;
        }

        return count;
    }
}