class Solution {
    String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        StringBuilder sb = new StringBuilder(split[2]);
        sb.append("-");

        for (int i = 0; i < month.length; ++i) {
            if (month[i].equals(split[1])) {
                if (i < 9) sb.append("0");
                sb.append(i+1);
            }
        }
        sb.append("-");

        int day = split[0].charAt(0) - '0';
        if (split[0].charAt(1) < 58) {
            day = 10 * (split[0].charAt(0) - '0') + split[0].charAt(1) - '0';
        }
        else {
            day = split[0].charAt(0) - '0';
            sb.append("0");    
        }
        sb.append(day);

        return sb.toString();
    }
}
