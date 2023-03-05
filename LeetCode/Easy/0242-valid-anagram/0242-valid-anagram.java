class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sh = new HashMap<>();
        HashMap<Character, Integer> th = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            sh.put(s.charAt(i), sh.getOrDefault(s.charAt(i), 0) + 1);
            set.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); ++i) {
            th.put(t.charAt(i), th.getOrDefault(t.charAt(i), 0) + 1);
            set.add(t.charAt(i));
        }

        for (Character key : set) {
            // System.out.print(key);
            // System.out.print(" / ");
            // System.out.print(sh.get(key));
            // System.out.print(" / ");
            // System.out.println(th.get(key));
            if ((int)sh.getOrDefault(key, 0) != (int)th.getOrDefault(key, 0)) return false;
        }
        return true;
    }
}