class Solution {
    /**
        [3,2,4,1]
        i = 3 ,maxIndex = 2 ans -> [3] 4 2 3 1  -> 1 3 2 4 3 1 2 4 2 1 3 4 1 2 3 4
    */
    
    public void reverse(int arr[],int left,int right){
        while(left<=right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left+=1;
            right-=1;
        }
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            int maxIndex = i;
            for(int j=i-1;j>=0;j-=1){
                maxIndex = arr[j] > arr[maxIndex]?j:maxIndex;
            }
            if(maxIndex!=i){
                reverse(arr,0,maxIndex);
                res.add(maxIndex+1);
                
                reverse(arr,0,i);
                res.add(i+1);
            }
        }
        return res;
    }
}