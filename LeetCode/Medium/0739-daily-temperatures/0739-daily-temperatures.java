class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[temperatures.length];

        int hot = temperatures[len - 1];

        for(int i = len - 2; i >= 0; --i) {

            // 뜨거운 값 찾으면 아무것도 하지않음
            if(temperatures[i] >= hot) {
                hot = temperatures[i];
                continue;
            }

            // 선택한 일자의 다음날부터
            // 작은수라면 그 작은수로 설정한 뜨거운 날짜를 찾아
            // 선택한 일자에 더함
            // 작은수의 뜨거운 날짜는 현재 날짜의 뜨거운 날짜가 될 수 있지만
            // 덧셈 처리하면 그 사이의 시행횟수를 줄일 수 있음
            // answer 배열로 구현한 Two Pointer 방식이 됨
            int day = 1;
            while (temperatures[i + day] <= temperatures[i]) {
                day += answer[i + day];
            }
            answer[i] = day;
        }

        return answer;
    }

    /**
     * Monotonic Stack 방식
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; ++i) {

            // 스택 없거나 줄어드는 쪽이라면 적재
            if(stack.size() == 0 || temperatures[stack.peek()] > temperatures[i]) {
                stack.push(i);
                continue;
            }

            // temperatures[stack.peek()] < temperatures[i] 인 경우임.
            while(stack.size() != 0 && temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                answer[pop] = i - pop;
            }

            stack.push(i);
        }

        return answer;
    }
}