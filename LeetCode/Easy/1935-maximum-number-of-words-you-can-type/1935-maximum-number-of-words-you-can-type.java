class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        boolean checked = true;
        boolean[] broken = new boolean[26];

        for (char c : brokenLetters.toCharArray()) broken[c - 'a'] = true;

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (checked) count++;
                checked = true;
            }
            else {
                if (!checked) continue;
                else if (broken[c - 'a']) {
                    checked = false;
                }
            }
        }

        if (checked) count++;

        return count;
    }
}