class Solution {
    private final String vowels = "aeiouAEIOU";
    public boolean halvesAreAlike(String s) {

        char[] ca = s.toCharArray();

        int a = 0;
        int b = 0;

        int half = ca.length / 2;

        for (int i = 0; i < half; ++i) {
            if (vowels.indexOf(ca[i]) != -1) a++;
        }

        for (int i = half; i < ca.length; ++i) {
            if (vowels.indexOf(ca[i]) != -1) b++;
        }

        return a == b;
    }

    public boolean halvesAreAlike2(String s) {

        char[] ca = s.toCharArray();

        int a = 0;
        int b = 0;

        int half = ca.length / 2;

        for (int i = 0; i < half; ++i) {
            if (ca[i] == 'a' || ca[i] == 'e' || ca[i] == 'i' || ca[i] == 'o' || ca[i] == 'u' ||
                ca[i] == 'A' || ca[i] == 'E' || ca[i] == 'I' || ca[i] == 'O' || ca[i] == 'U'
            ) {
                a++;
            }
        }

        for (int i = half; i < ca.length; ++i) {
            if (ca[i] == 'a' || ca[i] == 'e' || ca[i] == 'i' || ca[i] == 'o' || ca[i] == 'u' ||
                ca[i] == 'A' || ca[i] == 'E' || ca[i] == 'I' || ca[i] == 'O' || ca[i] == 'U'
            ) {
                b++;
            }
        }

        return a == b;
    }
}