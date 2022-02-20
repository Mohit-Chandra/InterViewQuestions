class Solution {
    /**
        [[1,4],[2,8],[3,6]]
        [[1,2],[1,4],[3,4]]
        
    **/
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
        int start = intervals[0][0],end = intervals[0][1];
        int res = 0;
        for(int i=1;i<n;i+=1){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(start<=currStart && end>=currEnd){
                res+=1;
            }else{
                if(currStart<=start && currEnd>=end)
                    res+=1;
                start = currStart;
                end = currEnd;
            }
        }
        return n-res;
    }
}