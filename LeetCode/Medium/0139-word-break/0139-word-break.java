class Solution {
    Set<String> history = null;
    public boolean wordBreak(String s, List<String> wordDict) {

        history = new HashSet<>();
        
        return this.recursive(s, wordDict, 0, new StringBuilder());
    }

    private boolean recursive(String s, List<String> wordDict,
                              int index, StringBuilder sb) {
        
        for (int i = 0; i < wordDict.size(); ++i) {

            if (s.length() - index < wordDict.get(i).length()) continue;

            int curIndex = index;

            // System.out.println(wordDict.get(i) + " ======= ");

            for (int j = 0; j < wordDict.get(i).length(); ++j) {
                
                if (s.charAt(curIndex) != wordDict.get(i).charAt(j)) {
                    // System.out.println("이 캐릭터와 > " + s.charAt(curIndex));
                    // System.out.println("일치 하지 않는 캐릭터 발견. > " + wordDict.get(i).charAt(j));
                    break;
                }

                if (curIndex == s.length() - 1) {
                    // 정답 찾음
                    return true;
                }
                else if (j == wordDict.get(i).length() - 1) {
                    curIndex++;
                    // System.out.println("찾은 단어 : " + wordDict.get(i));

                    sb.append(wordDict.get(i));
                    if (this.history.contains(sb.toString())) break;

                    // 현재 단어의 끝에 도달
                    boolean result = this.recursive(s, wordDict, curIndex, sb);
                    if (result) return result;
                    else this.history.add(sb.toString());
                }
                else {
                    // 다음 캐릭터 확인해야함
                    curIndex++;
                }
                
            }

            sb.setLength(index);
        }

        return false;
    }
}