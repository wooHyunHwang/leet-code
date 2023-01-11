class Solution {

    public int minimumRounds(int[] tasks) {
        
        int count = 0;

        // tasks -> Hash Map
        // Hash Map -> for

        HashMap<Integer, Integer> loop = new HashMap<>();
        for(int i = 0; i < tasks.length; ++i) {
            loop.put(tasks[i], loop.getOrDefault(tasks[i], 0) + 1);
        }

        for(Integer v : loop.values()) {
            if ( v == 1 ) {
                return -1;
            }

            int round = v / 3;

            switch(v % 3) {
                case 0 : count += round; break; // 반복문으로
                case 2 : count += round + 1; break; // + 1 올림
                case 1 : {
                        // 7 이상인 6n + 1 중 나눠 떨어지지 않는 항목 => 3(n - 1) + 4
                        // ex. 7, 13, 16
                        v -= 4;
                        count += 2;
                        count += v / 3;
                    
                }
            }
        }
        /*
        // 숫자 목록
        // List<Integer> list = Arrays.stream(tasks).boxed().toList(); // Collection -> IntStream / boxed wrapper
        // int[] target = Arrays.stream(tasks).distinct().toArray(); // 1,2,3,5,6,7,3
        for(int i = 0; i < target.length; i++) {
            // int targetCount = Collections.frequency(list, new Integer(target[i])); // 건수

            if ( targetCount == 1 ) {
                return -1;
            }

            int round = targetCount / 3;

            switch(targetCount % 3) {
                case 0 : count += round; break; // 반복문으로
                case 2 : count += round + 1; break; // + 1 올림
                case 1 : {
                        // 7 이상인 6n + 1 중 나눠 떨어지지 않는 항목 => 3(n - 1) + 4
                        // ex. 7, 13, 16
                        targetCount -= 4;
                        count += 2;
                        count += targetCount / 3;
                    
                }
            }
        }
        */

        return count;

    }

}