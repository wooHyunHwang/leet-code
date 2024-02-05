class Solution {
    // 1. indexOf
    public int firstUniqChar(String s) {

        int ans = Integer.MAX_VALUE;
        
        for (int i = 'a'; i <= 'z'; ++i) {
            int first = s.indexOf(i);
            int last = s.lastIndexOf(i);

            if (first != -1 && first == last) ans = Math.min(ans, first);
        }

        if (ans == Integer.MAX_VALUE) return -1;
        return ans;

    }

    // 2. Map 이용
    public int firstUniqChar2(String s) {
        // 나온 문자의 최초 등장 index를 저장
        Map<Integer, Character> map = new LinkedHashMap<>();
        // 단어가 등장한 횟수를 기록
        long[] check = new long[26];

        char[] cArr = s.toCharArray();

        for (int i = 0; i < cArr.length; ++i) {
            if (!map.containsValue(cArr[i])) map.put(i, cArr[i]);
            check[cArr[i] - 'a']++;
        }

        for (Integer key : map.keySet()) {
            if (check[map.get(key) - 'a'] == 1) return key;
        }
        return -1;
    }
}