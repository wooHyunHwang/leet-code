class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        int recentValue = nums2[0];
        stack.push(nums2[0]);

        for (int i = 1; i < nums2.length; ++i) {
            
            if (nums2[i] > recentValue) {
                // 증가하는 기점에서 스택 다 터트리기
                while (stack.size() != 0) {
                    if(stack.peek() > nums2[i]) break;
                    map.put(stack.pop(), nums2[i]);
                }
            }
            // 배열의 방향이 감소하는 경우 스택에 쌓고
            recentValue = nums2[i];
            stack.push(nums2[i]);
        }

        for (Integer small: stack) {
            map.put(small, -1);
        }

        for (int i = 0; i < nums1.length; ++i) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}