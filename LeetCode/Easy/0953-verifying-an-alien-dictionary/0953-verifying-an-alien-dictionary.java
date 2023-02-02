class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dic = new int[27];
        char[] orderChar = order.toCharArray();

        // 사전 생성
        for (int i = 0; i < orderChar.length; ++i) {
            dic[orderChar[i] - 96] = i;
        }

        // System.out.println("###");
        // for (int i = 1; i < dic.length; ++i) {
            // System.out.print(dic[i]);
        // }
        // System.out.println("");
        // System.out.println("###");
        
        for(int i = 0; i < words.length - 1; ++i) {

            if(dic[words[i].charAt(0) - 96] < dic[words[i+1].charAt(0) - 96]) {
                // 순서 맞음
            } else if(dic[words[i].charAt(0) - 96] == dic[words[i+1].charAt(0) - 96]) {
                // 순서 같음, 2뎁스 이상에서 순서 이상 탐색
                if(!checkNextDepth(dic, words[i], words[i+1], 1)) return false;
                
            } else {
                return false;
            }
            
        }
        return true;
    }

    public boolean checkNextDepth(int[] dic, String firstStr, String secondStr, int idx) {
        int fL = firstStr.length();
        int sL = secondStr.length();
        int maxL = Math.max(fL, sL);

        if (fL - 1 < idx) return true;
        if (sL - 1 < idx) return false;

        if(dic[(int)firstStr.charAt(idx) - 96] < dic[(int)secondStr.charAt(idx) - 96]) {
            // 다음 알파벳이 큰게 맞음 true
            return true;

        } else if (dic[(int)firstStr.charAt(idx) - 96] == dic[(int)secondStr.charAt(idx) - 96]) {
            // 이번 항목도 같음
            // 다음 알파벳 비교
            idx++;
            return checkNextDepth(dic, firstStr, secondStr, idx);
        } else {
            // 앞의 알파벳이 큼 false
            return false;
        }

    }
















}