class Solution {
    public int minFlips(int a, int b, int c) {

        System.out.println("###########");
        System.out.println(7 | 7);
        System.out.println("###########");

        char[] aC = Integer.toBinaryString(a).toCharArray();
        char[] bC = Integer.toBinaryString(b).toCharArray();
        char[] cC = Integer.toBinaryString(c).toCharArray();

        int length = Math.max(Math.max(aC.length, bC.length), cC.length);

        int flip = 0;

        // 0 1 1 1
        // 0 1 1 1
        // 0 1 1 1

        for(int i = 0; i < length; ++i) {
            int aI = aC.length - i - 1;
            int bI = bC.length - i - 1;
            int cI = cC.length - i - 1;

            // 뒤에부터 꺼냄
            char aChar = aI >= 0 ? aC[aI] : '0';
            char bChar = bI >= 0 ? bC[bI] : '0';
            char cChar = cI >= 0 ? cC[cI] : '0';

            // 하나라도 1이라면 ok
            if(cChar == '0') {
                if(aChar == '1') flip++;
                if(bChar == '1') flip++;
            }
            else if (cChar == '1') {
                if(aChar == '0' && bChar == '0') flip++;
            }
        }

        return flip;
    }
}