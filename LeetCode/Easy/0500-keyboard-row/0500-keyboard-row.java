class Solution {

    int[] keyLine = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

    public String[] findWords(String[] words) {
        
        StringBuilder ans = new StringBuilder();

        for(String word : words) {

            int line = keyLine[this.charToIdx(word.charAt(0))]; // 첫번째 알파벳의 키보드 라인 추출
            boolean check = true;

            for(char alphabet : word.toCharArray()) {
                if(line != keyLine[this.charToIdx(alphabet)]) {
                    check = false;
                    break;
                }
            }

            if (check) {
                ans.append(word);
                ans.append("/");
            }
        }
        
        if(ans.length() > 0) {
            return ans.substring(0, ans.length() - 1).toString().split("/");
        } else {
            return new String[0];
        }
        
    }

    private int charToIdx(char alphabet) {
        if(alphabet >= 'a') {
            // 대문자
            return (int)(alphabet - 'a');
        } else {
            // 소문자
            return (int)(alphabet - 'A');
        }
    }
}