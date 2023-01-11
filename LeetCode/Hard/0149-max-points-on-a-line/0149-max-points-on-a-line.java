class Solution {
    public int maxPoints(int[][] points) {
        
        // y - y1 = m(x - x1) >>> m = (y - y1) / (x - x1)
        int max = 0;
        // HashMap<Double, Integer> slope; = new HashMap<>();

        for (int i = 0; i < points.length - 1; ++i) {
            if(max >= points.length) {
                break;
            }
            HashMap<Double, Integer> slope = new HashMap<>();

            // i 번째의 기울기들을 전부 구하기
             for (int j = i + 1; j < points.length; ++j) {
                double lean = (1.0 * points[i][1] - points[j][1]) / (1.0 * points[i][0] - points[j][0]);
                // System.out.println("i: " + i + ", j: " + j + ", lean :" + lean);

                if(lean == -0.0) {
                    lean = 0.0; // 0값 통일
                }
                if(Double.isInfinite(lean)) {
                    lean = 9999999; // 무한 고정
                }
                if(Double.isNaN(lean)) {
                    lean = 9999998; // 무한 고정
                }

                slope.put(lean, slope.getOrDefault(lean, 0) + 1);
            }
            max = Math.max(max, Collections.max(slope.values()));
            // slope.clear();
        }
        
        // 선의 갯수기 때문에 점이면 + 1
        max++;

        return max;
    }
}