class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String s : word1) sb1.append(s);
        for (String s : word2) sb2.append(s);

        return sb1.toString().equals(sb2.toString());

    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {

        int length1 = 0;
        int length2 = 0;

        for(String s : word1) length1 += s.length();
        for(String s : word2) length2 += s.length();

        if (length1 != length2) return false;

        int count = 0;        

        int idx1 = 0;
        int idx2 = 0;

        int wrap1 = 0;
        int wrap2 = 0;
        
        while(count < length1) {

            if (idx1 >= word1[wrap1].length()) {
                idx1 = 0;
                wrap1++;
            }

            if (idx2 >= word2[wrap2].length()) {
                idx2 = 0;
                wrap2++;
            }

            if (word1[wrap1].charAt(idx1) != word2[wrap2].charAt(idx2)) return false;

            idx1++;
            idx2++;
            count++;
        }

        return true;
    }
}