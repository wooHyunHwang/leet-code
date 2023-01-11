class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0;
        int totCos = 0;
        for (int i = 0; i < gas.length; ++i) {
            totGas += gas[i];
            totCos += cost[i];
        }

        if(totGas < totCos) return -1;

        // Initialize remainsGas and start to 0
        int remainsGas = 0, start = 0;
        // Iterate through all the gas stations
        for(int i = 0 ; i < gas.length; i++){
            // Add the difference between gas and cost at each station to remainsGas
            remainsGas = remainsGas +(gas[i] - cost[i]);
            // If remainsGas becomes negative, set start to the next station and reset remainsGas to 0
            if(remainsGas < 0 ){
                start = i+1;
                remainsGas = 0;
            }
        }
        // Return the starting station
        return start;

        /*
        // 필요없는 구간 제외(단축)

        for (int i = 0; i < gas.length; ++i) {

            boolean suces = false;
            int tank = gas[i];
            int currentPosition = i;
            int nextPosition = i;

            if(cost[i] > gas[i]) {
                continue;
            }

            // System.out.println("====================== : " + i);

            for (int j = 0; j < gas.length; ++j) {
                nextPosition++;
                if(nextPosition > gas.length - 1) {
                    nextPosition = 0;
                }

  

                // System.out.println("==== 현재 정거장 : " + currentPosition);
                // System.out.println("==== 목표 정거장 : " + nextPosition);
                // System.out.println("연료 사용 전 : " + tank);
                // Your tank
                tank -= cost[currentPosition];
                // System.out.println("사용 가스 [currentPosition] : " + cost[currentPosition]);

                // 가스 부족 체크
                // System.out.println("연료 사용 후 : " + tank);
                if (tank < 0) {
                    // System.out.println("가스 부족 시점 : " + j);

                    suces = false;
                    break;
                }

                // 한바퀴 도는데 성공함
                // System.out.println("반복 횟수 : " + j);
                // System.out.println("스테이션 개수 : " + gas.length);
                if (j == gas.length - 1) {
                    // System.out.println("골인!!!");
                    suces = true;
                    break;
                }


                // 이동 성공, 가스 충전
                tank += gas[nextPosition];

                // System.out.println("충전 후 : " + tank);

                currentPosition++;
                if(currentPosition > gas.length - 1) {
                    currentPosition = 0;
                }

            }

            if(suces) {
                return i;
            }
        }

        return -1;
        */
         
    }

    
}