class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 0) return new int[0];


        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(asteroids[0]);

        for(int i = 1; i < asteroids.length; ++i) {

            int next = asteroids[i];

            // 값이 나란히 달리는 경우 구분값
            boolean added = false;

            if(stack.size() == 0) {
                stack.add(next);
                continue;
            }

            // 이번 인자가 파괴되거나 나란히 달릴때까지 반복
            while(!added && stack.size() != 0) {
                int last = stack.getLast();

                // System.out.println("비교 : " + last + " / " + next);

                if((last > 0 && next > 0) || (last < 0 && next < 0) || (last < 0 && next > 0)) {
                    // 추가되는 경우
                    added = true;
                    stack.add(next);
                } else {
                    // 충돌하는 경우
                    if(Math.abs(last) > Math.abs(next)) {
                        break;
                    } else if (Math.abs(last) < Math.abs(next)) {
                        stack.removeLast();
                        if(stack.size() == 0) {
                            added = true;
                            stack.add(next);
                        }
                    } else {
                        stack.removeLast();
                        break;
                    }
                }
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}