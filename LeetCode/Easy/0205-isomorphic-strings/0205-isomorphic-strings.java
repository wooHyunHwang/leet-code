class Solution {
    public boolean isIsomorphic(String s, String t) {

        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {

            if(m.containsKey((int)s.charAt(i))) {

                if (m.get((int)s.charAt(i)) != (int)t.charAt(i)) {
                    return false;
                }

            } else {
                m.put((int)s.charAt(i), (int)t.charAt(i));
            }

            if(m2.containsKey((int)t.charAt(i))) {

                if (m2.get((int)t.charAt(i)) != (int)s.charAt(i)) {
                    return false;
                }

            } else {
                m2.put((int)t.charAt(i), (int)s.charAt(i));
            }

        }
        return true;

    }
}