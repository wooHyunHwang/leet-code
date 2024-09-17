class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : s1.split(" ")) {
            //System.out.println(s);
            map.put(
                s,
                map.getOrDefault(s, 0)+1
            );
        }
        for (String s : s2.split(" ")) {
            //System.out.println(s);
            map.put(
                s,
                map.getOrDefault(s, 0)+1
            );
        }

        //System.out.println("=====");

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            //System.out.println(key);
            if (map.get(key) == 1) {
                list.add(key);
            }
        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}