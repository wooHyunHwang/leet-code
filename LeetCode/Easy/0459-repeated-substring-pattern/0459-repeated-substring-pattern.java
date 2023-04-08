class Solution {
    public boolean repeatedSubstringPattern(String s) {

        if(s.length() == 0) return false;

        int i = 1; // 자르는 길이

        while (i <= s.length() / 2) {

            int j = 0; // 시작 idx

            // System.out.println("====== 탐색");

            while(true) {
                /*
                System.out.print(
                    i + ", " + j +
                    " = " + j + "," + (j+i) + " / " + (j+i) + "," + (j+i+i) + " ----- "
                );
                System.out.println(
                    "[" +
                    s.substring(j, j+i) + " / " +
                    s.substring(j+i, j+i+i) +
                    "]"
                );
                */

                if(s.length() % i != 0) {
                    // System.out.println("!!! 이번 회차에 처리할 수 없는 길이");
                    break;
                }
                
                if(s.substring(j, j+i).equals(
                    s.substring(j+i, j+i+i)
                )) {

                    j = j+i;


                    if (j+i+i > s.length()) {
                        // System.out.println("!!! 찾음");
                        return true;
                    }

                } else {
                    // System.out.println("일치하지 않음.. 다음");
                    break;
                }
            }

            i++;
        }

        return false;
    }
}