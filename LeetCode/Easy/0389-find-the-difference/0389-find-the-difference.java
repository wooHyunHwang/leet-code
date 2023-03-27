class Solution {
    public char findTheDifference(String s, String t) {

        if(t.length() <= 0) return '0';
        if(t.length() <= 1) return t.charAt(0);

        char[] tChar = t.toCharArray();
        Arrays.sort(tChar);

        int[] dictionary = new int[26];

        for(char c : s.toCharArray()) {
            dictionary[c - 'a']++;
        }

        int accumulate = 0;

        System.out.println(new String(tChar));

        for(int i = 0; i < dictionary.length; ++i) {
            accumulate += dictionary[i];
            if (tChar[accumulate - 1] - 'a' != i || tChar[accumulate] - 'a' == i)
                return tChar[accumulate];
        }

        return '0';
    }
}