class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0L;
        int left = 0;
        int right = costs.length - 1;

        // {좌표, 값}
        PriorityQueue<int[]> queue = new PriorityQueue<>((c1, c2) -> {

            if(c1[1] > c2[1]) return 1;
            else if (c1[1] < c2[1]) return -1;
            else return c1[0] > c2[0] ? 1 : -1;
        });

        // 최초 큐 담기
        if(candidates * 2 >= costs.length) {
            for(int i = 0; i < costs.length; ++i) {
                queue.add(new int[]{i, costs[i]});
            }
            right = left;
        } else {
            left = candidates - 1;
            right = costs.length - candidates;
            for(int i = 0; i <= left; ++i) queue.add(new int[]{i, costs[i]});
            for(int i = costs.length - 1; i >= right; --i) queue.add(new int[]{i, costs[i]});
        }

        // k번 반복
        for(int i = 0; i < k; ++i) {

            // 1. 현재 회차 가장 작은 수 추출
            int[] minimum = queue.poll();
            ans += minimum[1];

            // System.out.print(" 뽑은 수 : " + minimum[1] + " / ");

            // 예외 > left == right 면 모든 수가 담긴거. 그냥 추출만 해도 됨
            if(left == right) continue;

            // 2. 다음 회차를 위해 뽑은 수를 바탕으로 left, right 변경
            // 3. 다음 회차를 위해 다음 수를 집어넣음
            if(minimum[0] <= left) {
                // 왼쪽꺼 꺼낸경우
                left++;
                if(left == right) continue;
                // System.out.print("(" + left + " added + "+costs[left] + ") ");
                queue.add(new int[]{left, costs[left]});
                // System.out.println("왼쪽꺼임");

            } else if(minimum[0] >= right) {
                // 오른쪽꺼 꺼낸경우
                right--;
                if(left == right) continue;
                // System.out.print("(" + right + " added + "+costs[right] + ") ");
                queue.add(new int[]{right, costs[right]});
                // System.out.println("오른쪽꺼임");
            }
        }

        return ans;
    }

    // Timeout
    public long totalCost2(int[] costs, int k, int candidates) {
        long ans = 0L;

        LinkedList<Integer> linkedScoreList = new LinkedList<>();
        for(int c : costs) {
            linkedScoreList.add(c);
        }

        for(int s = 1; s <= k; ++s) {
            
            // k 만큼 반복
            int findMinIdx = 0;
            int findMin = Integer.MAX_VALUE;
            
            for(int i = 0; i < candidates * 2; ++i) {
                int realIdx = i;
                if (i >= candidates) realIdx = linkedScoreList.size() - 1 - i + candidates;
                // System.out.print(realIdx);
                if(realIdx < 0 || linkedScoreList.size() <= realIdx) continue;
                if(findMin > linkedScoreList.get(realIdx)) {
                    findMinIdx = realIdx;
                    findMin = linkedScoreList.get(realIdx);
                }
            }
            // System.out.println();
            // System.out.println("삭제 : " + findMin);
            
            linkedScoreList.remove(findMinIdx); // Timeout, linkedlist로 변경
            // TODO Future, 좌우 Index 기록하여 접근하는 투포인터 방식으로 속도 향상 필요
            
            // System.out.println("찾은 값 : " + findMin);
            
            ans += findMin;
        }

        return ans;   
    }
}