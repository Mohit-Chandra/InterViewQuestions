class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(p1,p2)->Integer.compare(p1[1],p2[1]));
        int arrows = 1,last = points[0][1],start,end;
        for(int point[] : points){
            start = point[0];
            end = point[1];
            if(last < start){
                arrows+=1;
                last = end;
            }
        }
        return arrows;
    }
}