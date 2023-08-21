class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();

        int idx = 0;
        int sumLength = 0;
        Queue<String> q = new LinkedList<>();

        while(idx < words.length) {

            if (sumLength + words[idx].length() > maxWidth) {
                // System.out.println("==== Flush ====");
                ans.add(this.flushQueue(q, maxWidth, sumLength));
                sumLength = 0;
            }

            // System.out.println(words[idx]);
            q.add(words[idx]);
            sumLength += words[idx].length() + 1;

            idx++;
        }

        // Flush Last
        if (!q.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while(!q.isEmpty()) {
                sb.append(q.poll());
                if (!q.isEmpty()) sb.append(" ");
            }
            ans.add(sb.toString() + this.getEmptyString(maxWidth - sb.length()));
        }


        // System.out.println("==== End ====");

        return ans;
    }

    private String flushQueue(Queue<String> q, int maxWidth, int sumLength) {

        if(q.size() == 1) {
            String word = q.poll();
            return word + this.getEmptyString(maxWidth - word.length());
        }

        int emptySpaceCnt = q.size() - 1;
        int stringLen = sumLength - q.size();
        int emptySpace = emptySpaceCnt != 0 ? (maxWidth - stringLen) / emptySpaceCnt : 1;
        int rest = (maxWidth - stringLen) % emptySpaceCnt;

        StringBuilder sb = new StringBuilder();

        while(true) {
            sb.append(q.poll());
            if(q.isEmpty()) break;

            int empty = emptySpace;
            if (rest > 0) {
                empty++;
                rest--;
            }

            sb.append(this.getEmptyString(empty));
        }

        return sb.toString();
    }

    private String getEmptyString(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            sb.append(" ");
        }
        return sb.toString();
    }
}