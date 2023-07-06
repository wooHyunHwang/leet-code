class Solution {
    public String tictactoe(int[][] moves) {
        // 1: O, -1: X, 0: 미지정
        int[][] toe = new int[3][3];

        boolean user = true; // true: A, false: B
        for(int q = 0; q < moves.length; ++q) {

            int i = moves[q][0];
            int j = moves[q][1];

            // 중복 위치 검사
            if(toe[i][j] != 0) {
                user = !user;
                continue;
            }

            // 값 추가
            if(user) toe[i][j] = 1;
            else toe[i][j] = -1;
            user = !user;

            // 십자가 case
            // 세로
            int sumX = 0;
            int sumY = 0;
            for(int w = 0; w < 3; ++w) {
                sumX += toe[i][w];
                sumY += toe[w][j];
            }

            if(Math.abs(sumX) == 3) {
                if(sumX > 0) return "A";
                else return "B";
            }

            if(Math.abs(sumY) == 3) {
                if(sumY > 0) return "A";
                else return "B";
            }
            
            // X Case
            if((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
                // 좌상 우하
                int sum = toe[0][0] + toe[1][1] + toe[2][2];
                if(Math.abs(sum) == 3) {
                    if(sum > 0) return "A";
                    else return "B";
                }
            }
            if((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                // 우상 좌하
                int sum = toe[0][2] + toe[1][1] + toe[2][0];
                if(Math.abs(sum) == 3) {
                    if(sum > 0) return "A";
                    else return "B";
                }
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

// O O O
// X - -
// X - X
}