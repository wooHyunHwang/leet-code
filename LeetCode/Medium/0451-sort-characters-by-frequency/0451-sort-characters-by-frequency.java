class Solution {
    public static class Alphabet {
        public int count = 0;
        public char c;

        public Alphabet(char c) {
            this.c = c;
        }
        public void plus() {
            this.count++;
        }
    }
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Alphabet[] stack = new Alphabet[75];

        for (char c = '0'; c <= '9'; ++c) {
            stack[c - '0'] = new Alphabet(c);
        }

        for (char c = 'A'; c <= 'Z'; ++c) {
            stack[c - '0'] = new Alphabet(c);
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            stack[c - '0'] = new Alphabet(c);
        }

        for (char c : s.toCharArray()) {
            stack[c - '0'].plus();
        }

        Arrays.sort(stack, new Comparator<Alphabet>() {
            public int compare(Alphabet l, Alphabet r) {
                if (l == null && r == null) return 0;
                else if (l == null) return 1;
                else if (r == null) return -1;

                return r.count - l.count;
            }
        });

        for (Alphabet a : stack) {
            
            if (a == null || a.count == 0) continue;
            for (int i = 0; i < a.count; ++i) {
                sb.append(a.c);
            }
        }

        return sb.toString();
    }
}