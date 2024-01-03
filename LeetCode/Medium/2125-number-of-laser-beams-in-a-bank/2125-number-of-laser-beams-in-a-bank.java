class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0;
        int prev = 0;

        for (char c : bank[0].toCharArray()) {
            if (c == '1') prev++;
        }

        for (int i = 1; i < bank.length; ++i) {

            int light = 0;

            for (char c : bank[i].toCharArray()) {
               light += c - '0';
            }

            if (light != 0) {
                sum += light * prev;
                prev = light;
            }
        }

        return sum;
    }
}