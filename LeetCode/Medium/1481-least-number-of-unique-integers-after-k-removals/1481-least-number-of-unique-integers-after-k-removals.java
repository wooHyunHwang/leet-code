class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            int count = map.getOrDefault(a, 0) + 1;
            map.put(a, count);
            if (maxCount < count) maxCount = count;
        }

        int ans = map.size();
        int[] countAry = new int[maxCount+1];

        for (Integer key : map.keySet()) {
            countAry[map.get(key)]++;
        }

        int i = 1;
        while(i < countAry.length) {
            if (countAry[i] == 0) {
                i++;
                continue;
            }
            countAry[i]--;
            k -= i;
            ans--;
            if (k < i) break;
        }

        return k < 0 ? ans + 1 : ans;
    }
}