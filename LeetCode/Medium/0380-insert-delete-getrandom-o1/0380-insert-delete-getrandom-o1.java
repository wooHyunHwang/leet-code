class RandomizedSet {
    // Key: 값, value: 배열 index
    private Map<Integer, Integer> map;
    private List<Integer> list;

    private final Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        Integer removeIdx = map.get(val);
        if (removeIdx == null) return false;
        int changeVal = list.get(list.size()-1);
        

        list.set(removeIdx, changeVal);
        map.put(changeVal, removeIdx);

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        
        return list.get(rand.nextInt(list.size()));
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */