class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        if (startGene.equals(endGene)) return 0;

        Queue<String> queue = new LinkedList<>();
        boolean[] used = new boolean[bank.length];

        queue.add(startGene);
        
        int mutationCount = 0;
        while(!queue.isEmpty()) {

            mutationCount++;
            Queue<String> newQueue = new LinkedList<>();

            while(!queue.isEmpty()) {
                String curr = queue.poll();

                for (int i = 0; i < bank.length; ++i) {
                    if (used[i]) continue;
                    else if (this.check1Char(curr, bank[i])) {

                        if (endGene.equals(bank[i])) return mutationCount;

                        newQueue.add(bank[i]);
                        used[i] = true;
                    }
                }


            }

            queue = newQueue;
        }

        return -1;
    }

    private boolean check1Char(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < 8; ++i) {

            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) return false;
            }

        }
        return count == 1;
    }
}