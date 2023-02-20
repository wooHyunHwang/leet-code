public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        System.out.println(n);
        System.out.println(Integer.MAX_VALUE);

        String binaryString = Integer.toBinaryString(n);

        // System.out.println(binaryString);

        StringBuilder sb = new StringBuilder();

        for (int i = binaryString.length() - 1; i >= 0; --i) {
            sb.append(binaryString.charAt(i));
        }
        for (int i = binaryString.length(); i < 32; ++i) {
            sb.append(0);
        }

        // System.out.println(sb.toString());
        
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}