class Solution {
    public String sortString(String s) {

        int length = s.length();

        StringBuilder sb = new StringBuilder();

        char[] cAry = s.toCharArray();
        int[] coordList = new int[26];
        Arrays.sort(cAry);
        Arrays.fill(coordList, -1);
        coordList[0] = 0;

        int count = 1;
        for (int i = 1; i < length; ++i) {
            if (cAry[i] != cAry[i-1]) coordList[count++] = i;
        }
        
        while(sb.length() < length) {

            // System.out.println("=========" + sb.length() + " / " + length);

            for (int i = 0; i < count; ++i) {
                // System.out.print(coordList[i] + " - ");
                if (coordList[i] != -1 && coordList[i] < length) {
                    sb.append(
                        cAry[coordList[i]++]
                    );
                    if (coordList[i] >= length || cAry[coordList[i]-1] != cAry[coordList[i]]) {
                        coordList[i] = -1;
                    }
                }
            }
            // System.out.println(sb.toString());

            for (int i = count -1; i >= 0; --i) {
                // System.out.print(coordList[i] + " - ");
                if (coordList[i] != -1 && coordList[i] < length) {
                    sb.append(
                        cAry[coordList[i]++]
                    );
                    if (coordList[i] >= length || cAry[coordList[i]-1] != cAry[coordList[i]]) {
                        coordList[i] = -1;
                    }
                }
            }
            // System.out.println(sb.toString());
        }

        return sb.toString();
    }
}