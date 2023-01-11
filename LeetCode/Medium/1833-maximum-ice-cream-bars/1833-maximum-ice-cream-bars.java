class Solution {
    // 그리디 알고리즘
    public int maxIceCream(int[] costs, int coins) {
        /*
        // Arrays의 정렬을 사용하면 효율이 안좋음
        Arrays.sort(costs);
        int count = 0;
        for( int i = 0; i < costs.length; ++i ) {
            if ( costs[i] <= coins ) {
                coins -= costs[i];
                count++;
            } else {
                return count;
            }
        }
        return count;
        */

        int maxCost = 0;
        
        // 제일 비싼 항목을 추출함
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        // 구매 가능한 코인 목록 (오락실 코인이라 생각해보자)
        // 0번째는 0코인이라 들어올일 없어서 + 1
        int[] numOfCosts = new int[maxCost + 1];

        // 구매 가능한 코인 배열에 건수를 하나씩 증가
        for (int cost : costs) {
            numOfCosts[cost]++;
        }

        // 구매할 막대 아이스크림
        int iceCreamBars = 0;

        // 1원부터 최대값까지 반복 시작
        for (int cost = 1; cost <= maxCost; cost++) {
            if (numOfCosts[cost] == 0) {
                // 구매 가능 건수 0이면 아무것도 안함
                continue;
            }

            if (coins < cost) {
                // 돈 없으면 끝
                break;
            }
            
            // 재고 건수와 소지금으로 구매 가능한 건수 중 최소값 구함
            int count = Math.min(numOfCosts[cost], coins / cost);
            // 현재 소지금에서 차감
            coins -= count * cost;
            // 아슈크림 건수 증가
            iceCreamBars += count;
        }

        return iceCreamBars;

        /*
        HashMap<Integer, Integer> slot = new HashMap<>();
        int max = 0;

        for (int i = 0; i < costs.length; ++i) {
            max = Math.max(max, costs[i]);
            slot.put(costs[i], slot.getOrDefault(costs[i], 0) + 1);
        }

        int iceCreamBars = 0;

        for (int i = 1; i <= max; ++i) {
            if (slot.get(i) == null) {
                // 구매 가능 건수 0이면 아무것도 안함
                continue;
            }

            if (coins < i) {
                // 돈 없으면 끝
                break;
            }
            int count = Math.min(slot.get(i), coins / i);
            // 현재 소지금에서 차감
            coins -= count * i;
            // 아슈크림 건수 증가
            iceCreamBars += count;
        }

        return iceCreamBars;
        */





    }
}