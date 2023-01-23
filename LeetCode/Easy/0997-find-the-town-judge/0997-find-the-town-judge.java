class Solution {
    public int findJudge(int n, int[][] trust) {

        if (trust.length == 0 && n == 1) return 1;

        // 사람 X는 몇번 신뢰를 받고있는지
        HashMap<Integer, Integer> people = new HashMap<>();

        // 누군가를 신뢰한다고 했던 사람
        HashSet<Integer> mentioned = new HashSet<>();

        for (int i = 0; i < trust.length; ++i) {

            // 사람 X는 몇번 신뢰를 받고있는지 기록
            people.put(trust[i][1], people.getOrDefault(trust[i][1], 0) + 1);

            // 누군가를 신뢰한다고 했던 사람 기록
            mentioned.add(trust[i][0]);
        }

        // 신뢰를 받고 있는 건수가 n-1 건인 사람이면
        for (Integer label : people.keySet()) {
            if (people.get(label) == n - 1) {
                // Judge로 의심됨, 신뢰 언급을 했는지 확인
                if(!mentioned.contains(label)) {
                    return label;
                }
            }
	    }
        // 만약 아무런 언급도 하지 않은경우 return

        return -1;
    }
}