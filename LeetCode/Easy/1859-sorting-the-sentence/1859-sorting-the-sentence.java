class Solution {
    public String sortSentence(String s) {

        String[] ss = s.split(" ");
        String[] sss = new String[ss.length];

        for (String str : ss) {
            char[] c = str.toCharArray();
            sss[c[c.length-1] - '1'] = new String(c, 0, c.length-1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sss.length; ++i) {
            sb.append(sss[i]);
            if (i != sss.length -1) sb.append(" ");
        }

        return sb.toString();
    }
}