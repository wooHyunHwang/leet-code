class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; ++i) {
            List<Integer> iLevel = new ArrayList();

            for(int j = 0; j <= i; ++j) {
                if(j == 0 || j == i) {
                    // 사이드 값
                    iLevel.add(1);
                } else {
                    // 가운데 값 계산
                    iLevel.add(
                        ans.get(i-1).get(j-1) + ans.get(i-1).get(j)
                    );
                }
            }


            ans.add(iLevel);
        }

        return ans.get(rowIndex);
    }
}