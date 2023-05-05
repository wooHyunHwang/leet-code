class Solution {
    // 누적합
    public int maxVowels(String s, int k) {
        int ans = 0;
        int[] sAry = new int[s.length()];
        char[] scAry = s.toCharArray();
        int checked = 0;

        for(int i = 0; i < scAry.length; ++i) {
            if(scAry[i] == 'a' || scAry[i] == 'e' || scAry[i] == 'i' || scAry[i] == 'o' || scAry[i] == 'u') {
                checked++;
            }
            sAry[i] = checked;
        }

        for(int i = k - 1; i < sAry.length; ++i) {

            if (i == k - 1) {
                ans = Math.max(ans, sAry[i]);
            } else {
                ans = Math.max(ans, sAry[i] - sAry[i - k]);
            }
        }

        return ans;
    }


    // 큐 이용
    public int maxVowels2(String s, int k) {

        int ans = 0;
        char[] sAry = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        int checked = 0;

        // Queue 초기값
        for(int i = 0; i < k; ++i) {
            queue.add(sAry[i]);
            if(sAry[i] == 'a' || sAry[i] == 'e' || sAry[i] == 'i' || sAry[i] == 'o' || sAry[i] == 'u') {
                checked++;
            }
        }

        ans = checked;

        for(int i = k; i < sAry.length; ++i) {
            // 큐에서 뺀 값이 보웰이면 마이너스
            char poll = queue.poll();
            if(poll == 'a' || poll == 'e' || poll == 'i' || poll == 'o' || poll == 'u') {
                checked--;
            }
            // 다음값 큐 처리
            queue.add(sAry[i]);
            if(sAry[i] == 'a' || sAry[i] == 'e' || sAry[i] == 'i' || sAry[i] == 'o' || sAry[i] == 'u') {
                checked++;
            }

            ans = Math.max(ans, checked);
        }

        return ans;
        
    }
}