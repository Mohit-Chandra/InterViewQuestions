class Solution {
    /**
    [[10,16],[2,8],[1,6],[7,12]]
    
    [[1,6],[2,8],[7,12],[10,16]]
    **/ 
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(p1,p2) -> Integer.compare(p1[0],p2[0]));
        int count = 1,start = points[0][0],last = points[0][1];
        for(int i=1;i<points.length;i+=1){
            if(last >= points[i][0]){
                last = Math.min(last,points[i][1]);
            }else{
                start = points[i][0];
                last = points[i][1];
                count+=1;
            }
        }
        return count;
    }
}