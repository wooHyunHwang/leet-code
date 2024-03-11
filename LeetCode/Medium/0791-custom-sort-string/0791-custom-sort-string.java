class Solution {
    public String customSortString(String order, String s) {

        StringBuilder sb = new StringBuilder();
        int[] dic = new int[26];

        for (char c : s.toCharArray()) {
            dic[c - 'a']++;
        }

        for (char c : order.toCharArray()) {

            int repeat = (int)(c - 'a');

            for (int i = 0; i < dic[repeat]; ++i) {
                sb.append(c);
            }

            dic[repeat] = 0;
        }

        for (int i = 0; i < 26; ++i) {

            char c = (char)('a' + i);

            for (int count = 0; count < dic[i]; ++count) {
                sb.append(c);
            }

        }

        return sb.toString();
    }
}