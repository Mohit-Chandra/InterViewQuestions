class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(interval->interval[0]));
        int last = intervals[0][1],start,end,count=0;
        for(int i=1;i<intervals.length;i+=1){
            start = intervals[i][0];
            end = intervals[i][1];
            if(last > start){
                count+=1;
                last = Math.min(last,end);
            }else{
                last = end;
            }
        }
        return count;
    }
}