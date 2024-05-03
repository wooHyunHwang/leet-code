class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len1 = v1.length;
        int len2 = v2.length;
        int len = len1 > len2 ? len1 : len2;

        // System.out.println(len1 + " !!!! " + len2);

        for (int i = 0; i < len; ++i) {
            int ver1 = 0;
            int ver2 = 0;

            if (i < len1) ver1 = Integer.parseInt(v1[i]);
            if (i < len2) ver2 = Integer.parseInt(v2[i]);

            // System.out.println(ver1 + "  =========  " + ver2);

            if (ver1 > ver2) return 1;
            else if (ver1 < ver2) return -1;
        }

        
        return 0;
    }
}