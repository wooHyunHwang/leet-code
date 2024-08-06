class Solution {
    public int minimumPushes(String word) {
        char[] ary = word.toCharArray();
        int[] dic = new int[26];

        for (char c : ary) {
            dic[c-'a']++;
        }

        Arrays.sort(dic);

        int count = 0;
        int i = 25;

        for (; i > 17; --i) {
            if (dic[i] == 0) return count;
            count += dic[i];
        }

        for (; i > 9; --i) {
            if (dic[i] == 0) return count;
            count += dic[i] * 2;
        }

        for (; i > 1; --i) {
            if (dic[i] == 0) return count;
            count += dic[i] * 3;
        }

        for (; i > -1; --i) {
            if (dic[i] == 0) return count;
            count += dic[i] * 4;
        }

        return count;
    }
}