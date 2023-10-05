class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);

        beginSet.add(beginWord);
        endSet.add(endWord);

        if (!wordList.contains(endWord)) return 0;

        int check = 1;

        while(!beginSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
                continue;
            }

            check++;

            for (String word : beginSet) {
                wordSet.remove(word);
            }

            Set<String> nextBegin = new HashSet<>();

            for (String word : beginSet) {
                char[] wc = word.toCharArray();

                for (int i = 0; i < wc.length; ++i) {
                    char backup = wc[i];
                    
                    for (char c = 'a'; c <= 'z'; ++c) {
                        wc[i] = c;
                        String s = new String(wc);

                        if (wordSet.contains(s)) {
                            if (endSet.contains(s)) return check;
                            nextBegin.add(s);
                        }
                    }
                    wc[i] = backup;
                }
                
            }

            beginSet = nextBegin;
        }

        return 0;
    }
    /* Slow Solution
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int ans = 1;
        boolean[] wordHistory = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);


        while(!queue.isEmpty()) {
            Queue<String> newQueue = new LinkedList<>();

            ans++;

            while(!queue.isEmpty()) {

                String curr = queue.poll();

                for (int i = 0; i < wordList.size(); ++i) {

                    if (wordHistory[i]) continue;
                    else if (this.diffOne(curr, wordList.get(i))) {
                        if (endWord.equals(wordList.get(i))) return ans;
                        newQueue.add(wordList.get(i));
                        wordHistory[i] = true;
                    }
                }

            }

            queue = newQueue;
        }

        return 0;

    }

    private boolean diffOne(String w1, String w2) {
        int check = 0;
        char[] wc1 = w1.toCharArray();
        char[] wc2 = w2.toCharArray();

        for (int i = 0; i < wc1.length; ++i) {
            if (wc1[i] != wc2[i]) {
                check++;
                if (check > 1) return false;
            }
        }

        return check == 1;
    }
    */
}