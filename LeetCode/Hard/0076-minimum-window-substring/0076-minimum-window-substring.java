class Solution {
    public String minWindow(String s, String t) {

        // 길이
        int m = s.length();
        int n = t.length();

        // 정답
        String minString = "";
        int min = Integer.MAX_VALUE;

        // 반복 돌릴 char 배열
        char[] sChar = s.toCharArray();

        // 데이터 확인용
        int[] original = new int[58];
        int[] checked = new int[58];
        int count = 0;
        
        for (char tChar : t.toCharArray()) {
            original[tChar - 65]++;
        }

        // 구간 반복
        int left = 0;
        int right = m - 1;
        // true: left, false: right
        boolean swit = false;
        while(right >= left) {

            if (swit) {
                // 스킵 케이스
                if (original[sChar[left] - 65] == 0) {
                    left++;
                    swit = false;
                    continue;
                }

                // 리셋
                count = 0;
                System.arraycopy(original, 0, checked, 0, 58);
                
                for(int i = left; i <= right; ++i) {
                    if (checked[sChar[i] - 65] != 0) {
                        checked[sChar[i] - 65]--;
                        count++;

                        if(n == count) {
                            int length = i + 1 - left;

                            if (length < min) {
                                minString = s.substring(left, i + 1);
                                min = length;
                            }

                            break;
                        }
                    }
                }

                left++;
                swit = false;

            } else {
                // 스킵 케이스
                if (original[sChar[right] - 65] == 0) {
                    right--;
                    swit = true;
                    continue;
                }

                // 리셋
                count = 0;
                System.arraycopy(original, 0, checked, 0, 58);
                
                for(int i = right; i >= left; --i) {
                    if (checked[sChar[i] - 65] != 0) {
                        checked[sChar[i] - 65]--;
                        count++;

                        if(n == count) {
                            int length = right + 1 - i;

                            if (length < min) {
                                minString = s.substring(i, right + 1);
                                min = length;
                            }

                            break;
                        }
                    }
                }

                right--;
                swit = true;
            }
            if (n == min) break;
        }

        return minString;
    }
}