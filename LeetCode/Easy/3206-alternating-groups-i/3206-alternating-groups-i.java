class Solution {
    public int numberOfAlternatingGroups(int[] colors) {

        int count = 0;
        int len = colors.length;

        if (colors[len-2] == colors[0] && colors[len-1] != colors[0]) count++;
        if (colors[len-1] == colors[1] && colors[0] != colors[1]) count++;
        for (int i = 2; i < len; ++i) if (colors[i-2] == colors[i] && colors[i-1] != colors[i]) count++;

        return count;
    }
}