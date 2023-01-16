class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        

        List<Integer[]> result = new ArrayList<>();

        Integer[] next = new Integer[2];

        boolean zeroV = false;
        boolean zeroVOne = false;

        for (int i = 0; i < intervals.length; ++i) {

            if(intervals[i][1] < newInterval[0] || newInterval[1] < intervals[i][0]) {
                if(zeroV) {
                    // 사이값이 발견됐었다면 한번 비워줌
                    zeroV = false;
                    result.add(next);
                    next = new Integer[2];

                }

                // 사이값 아님, 그냥 추가
                next[0] = intervals[i][0];
                next[1] = intervals[i][1];

                result.add(next);

                next = new Integer[2];

                if(!zeroVOne && i < intervals.length - 1) {
                    if(newInterval[0] > intervals[i][0] && newInterval[1] > intervals[i][0] &&
                    newInterval[0] < intervals[i+1][0] && newInterval[1] < intervals[i+1][0]) {
                        // 한번도 발견된 적 없고, 다음 두 값보다 작다면
                        next[0] = newInterval[0];
                        next[1] = newInterval[1];

                        result.add(next);

                        next = new Integer[2];
                        zeroVOne = true;
                    }
                    
                }

            } else {
                if(!zeroV) {
                    // 사이값을 처음 발견
                    zeroV = true;
                    // 하나라도 발견했음
                    zeroVOne = true;
                    // 작은쪽을 시작값으로 세팅
                    if(intervals[i][0] > newInterval[0]) {
                        next[0] = newInterval[0];
                    } else {
                        next[0] = intervals[i][0];
                    }

                }

                // 큰쪽을 1 위치에 계속 넣음
                if(intervals[i][1] > newInterval[1]) {
                    next[1] = intervals[i][1];
                } else {
                    next[1] = newInterval[1];
                }
            }

            Integer[] zxc = new Integer[2];
            zxc[0] = intervals[i][0];
            zxc[1] = intervals[i][1];
        }

        // 인터벌이 비어있는 경우
        if (intervals.length == 0) {
            zeroV = true;
            // 하나라도 발견했음
            zeroVOne = true;
            next[0] = newInterval[0];
            next[1] = newInterval[1];
        }

        if(zeroV) {
            // case: 사이값이 마지막값 / 인터벌이 비어있는 경우
            // 만약 반복문에서 해결못한 사이값이 있으면... 그냥 넣는다.
            result.add(next);
        }

        if(!zeroVOne && intervals.length != 0) {
            // 어떤 사이값도 발견하지 못함... 맨 앞이나 맨 뒤에 배치해줘야 하는 상황
            next[0] = newInterval[0];
            next[1] = newInterval[1];

            if(newInterval[1] < intervals[0][0]) {
                result.add(0, next);
            } else {
                result.add(next);
            }
        }


        int[][] parse = new int[result.size()][2];

        for(int i = 0; i < result.size(); ++i) {
            
            parse[i][0] = result.get(i)[0];
            parse[i][1] = result.get(i)[1];
        }

        return parse;
    }
}



















