class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();
        // key : char / value : index (존재할 경우 패턴과 비교)

        String[] sArr = s.split(" ");

        if (sArr.length != pattern.length()) return false;

        for(int i = 0; i < sArr.length; ++i) {
            if (map.containsKey(sArr[i])) {
                // 이미 나왔던 단어, 패턴 index 에 동일하게 존재하는건지 체크
                if ( !compareChar(pattern, map.get(sArr[i]), i) ) {
                    return false;
                }
            } else {
                // 처음 나와 저장
                map.put(sArr[i], i);
            }
            if (patternMap.containsKey(pattern.charAt(i))) {
                // 이미 나왔던 단어, 패턴 index 에 동일하게 존재하는건지 체크
                if ( !sArr[patternMap.get(pattern.charAt(i))].equals(sArr[i]) ) {
                    return false;
                }
            } else {
                // 처음 나와 저장
                patternMap.put(pattern.charAt(i), i);
            }
        }

        return true;
    }

    private boolean compareChar(String pattern, int i, int j) {
        return pattern.charAt(i) == pattern.charAt(j);
    }
}