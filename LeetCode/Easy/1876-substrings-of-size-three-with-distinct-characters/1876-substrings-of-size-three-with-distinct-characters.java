class Solution {
    public int countGoodSubstrings(String s) {
        
        char[] sChar = s.toCharArray();

        if (sChar.length < 3) return 0;

        int[] charList = new int[26];
        int dupCount = 0;
        int ans = 0;

        for (int i = 0; i < 3; ++i) {
            charList[sChar[i]-'a']++;
            if (charList[sChar[i]-'a'] > 1) dupCount++;
        }

        if (dupCount == 0) ans++;

        for (int i = 3; i < sChar.length; ++i) {
            charList[sChar[i]-'a']++;
            if (charList[sChar[i]-'a'] > 1) dupCount++;
            charList[sChar[i-3]-'a']--;
            if (charList[sChar[i-3]-'a'] > 0) dupCount--;

            // System.out.print(sChar[i] + "(" + charList[sChar[i]-'a'] + ") ------ " + sChar[i-3] + "(" + charList[sChar[i-3]-'a'] + ")");
            // System.out.println(" ====== " + dupCount);

            if (dupCount == 0) ans++;
        }

        return ans;
    }
}

// 0 = 2
// 1 = 1

// 0