class NumberContainers {

    Map<Integer,Integer> indexValMap;
    Map<Integer,TreeSet<Integer>> valIndexMap;
    public NumberContainers() {
        valIndexMap = new HashMap<>();
        indexValMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexValMap.containsKey(index)){
            int oldVal = indexValMap.get(index);
            TreeSet<Integer> indexSet = valIndexMap.get(oldVal);
            indexSet.remove(index);
            if(indexSet.isEmpty())
                valIndexMap.remove(oldVal);
        }
        indexValMap.put(index,number);
        valIndexMap.computeIfAbsent(number, s -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if(valIndexMap.containsKey(number))
        {
            return valIndexMap.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */