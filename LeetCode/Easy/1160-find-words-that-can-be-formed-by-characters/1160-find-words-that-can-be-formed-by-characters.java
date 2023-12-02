class Solution {
    public int countCharacters(String[] words, String chars) {

        int ans = 0;
        int[] dic = new int[26];

        for(char c : chars.toCharArray()) dic[c - 'a']++;

        for(String word : words) {

            int[] copyDic = new int[26];

            System.arraycopy(dic, 0, copyDic, 0, 26);

            char[] cAry = word.toCharArray();
            for (int i = 0; i < cAry.length; ++i) {

                copyDic[cAry[i] - 'a']--;
                if (copyDic[cAry[i] - 'a'] < 0) break;
                else if (i == cAry.length - 1) {
                    ans += word.length();
                }
            }
        }

        return ans;
    }
}