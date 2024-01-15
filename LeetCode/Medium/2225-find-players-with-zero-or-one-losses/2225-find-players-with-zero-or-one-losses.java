class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] score = new int[100_001];

        for (int[] matche : matches) {

            if (score[matche[0]] == 0) {
                score[matche[0]] = -1;
            }

            if (score[matche[1]] == -1) score[matche[1]] = 1;
            else score[matche[1]]++;
        }

        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for (int i = 1; i < 100_001; ++i) {
            if (score[i] == -1) {
                answer.get(0).add(i);
            }
            else if (score[i] == 1) {
                answer.get(1).add(i);
            }
        }

        return answer;
    }
    public List<List<Integer>> findWinners2(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> lose = new HashMap<>();

        for (int[] matche : matches) {
            win.put(matche[0], win.getOrDefault(matche[0], 0) + 1);
            lose.put(matche[1], lose.getOrDefault(matche[1], 0) + 1);
        }

        for(Integer key : win.keySet()){
            if (!lose.containsKey(key)) {
                answer.get(0).add(key);
            }
        }

        for(Integer key : lose.keySet()){
            if (lose.get(key).equals(1)) {
                answer.get(1).add(key);
            }
        }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }
}