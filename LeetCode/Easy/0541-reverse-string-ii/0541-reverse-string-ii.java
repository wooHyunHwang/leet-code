class Solution {
    public String reverseStr(String s, int k) {

        if(k <= 1 || s.length() <= 1) return s;

        StringBuilder sb = new StringBuilder();

        char[] sAry = s.toCharArray();
        int i = 0;
        int roll = 1;
        int lastIdx = sAry.length - 1;

        // System.out.println(sAry.length);

        while(i < sAry.length) {
            // System.out.println((i/k)%k);  // 80 / 10 => 
            if ((i/k)%2 != 0) {
                // 그냥 추가하는 사이값
                sb.append(sAry[i]);
                roll = 1;
            } else {
                int currentCoord = i + k - roll;

                // System.out.print("회차 : " + i + " / " + roll + " / ");
                // System.out.println(currentCoord);
                
                roll += 2;

                if(lastIdx < currentCoord) {
                    // System.out.println("넘치는 값 발견 : " + (currentCoord - lastIdx));
                    roll += (currentCoord - lastIdx);
                    currentCoord = lastIdx;
                }

                sb.append(sAry[currentCoord]);
            }
            i++;
        }

        // 3
        // 0 1 2 3 4 5 6 7 8 9
        // 나누기
        // 0 0 0 1 1 1 2 2 2 3 3 3 4 4 4
        // 2
        // 나머지
        // 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 

        // k = 8
        // length = 5
        // 0 / 4 > i + k - 1 = 0 + 8 - 1 = 7    > roll = 1 + 2 + 3
        // 1 / 3 > i + k - 6 = 1 + 8 - 6 = 3
        // 2 / 2 > i + k - 8 = 1 + 8 - 8 = 1

        // 0 > 2  i + k - 1
        // 2 > 0


        // k = 5
        // 0 / 4 > i + k - 1 = 0 + 5 - 1 = 4
        // 1 / 3 > i + k - 3 = 1 + 5 - 3 = 3
        // 2 / 2 > i + k - 5 = 2 + 5 - 5 = 2
        // 3 / 1 > i + k - 7 = 3 + 5 - 7 = 1
        // 4 / 0 > i + k - 9 = 4 + 5 - 9 = 0
        return sb.toString();
    }
}