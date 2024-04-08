class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int i = 0;
        int j = 0;
        int round = 0;
        int len = students.length;

        while (round != len) {
            if (i == len) i = 0;
            if (j >= len) break;
            // System.out.println(i + " === " + j);
            round++;
            if (students[i] == 2) {
                // 이미 통과
                i++;
                continue;
            }
            if (students[i] != sandwiches[j]) {
                // 다름
                i++;
            }
            else {
                // 같음
                students[i++] = 2;
                j++;
                round = 0;
            }
        }

        return len - j;
    }
}
