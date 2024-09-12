class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        int count = 0;

        for (char c : allowed.toCharArray()) {
            allow[c-'a'] = true;
        }

        for (String w : words) {
            // boolean[] checked = new boolean[26];
            count++;
            for (char c : w.toCharArray()) {
                if (!allow[c-'a']) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}