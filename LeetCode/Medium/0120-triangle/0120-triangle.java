class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        for(int i = triangle.size() - 2; i >= 0; --i) {
            int nextDepth = i + 1;
            for(int j = 0; j < triangle.get(i).size(); ++j) {
                triangle.get(i).set(
                    j,
                    triangle.get(i).get(j) +
                        Math.min(
                            triangle.get(nextDepth).get(j),
                            triangle.get(nextDepth).get(j + 1)
                        )
                );
            }
        }

        return triangle.get(0).get(0);
    }
}

// 2

// 2 2
// 3 4

// 2 2 2
// 3 3 4
// 6 5 7



// 2 2 2 2
// 3 3 3 4
// 6 5 5 7
// 4 1 8 3


// 2 2 2 2
// 5 5 5 6
// 11 10 10 13
// 15 11 18 16