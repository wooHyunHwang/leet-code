class Solution {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = (res + k) % i;
        }
        return res + 1;
    }
    public int findTheWinner2(int n, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; ++i) list.add(i);

        int idx = 0;

        while (list.size() > 1) {
            int next = (idx + k - 1) % list.size();
            list.remove(list.get(next));
            idx = next;
        }

        return list.get(0);
    }
}