class Solution {
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        return mergeSort(nums,0,n-1);
    }
    
    public int[] mergeSort(int nums[],int left,int right){
        if(left == right){
            int curr[] = new int[1];
            curr[0] = nums[left];
            return curr;
        }
        
        int mid = left+(right-left)/2;
        int leftArr[] = mergeSort(nums,left,mid);
        int rightArr[] = mergeSort(nums,mid+1,right);
        int merged[] = merge(leftArr,rightArr);
        return merged;
    }
    
    public int[] merge(int leftArr[],int rightArr[]){
        int i=0,j=0,k=0;
        int merged[] = new int[leftArr.length+rightArr.length];
        while(i<leftArr.length && j<rightArr.length){
            if(leftArr[i] <= rightArr[j]){
                merged[k++] = leftArr[i++];
            }else{
                merged[k++] = rightArr[j++];
            }
        }
        
        while(i<leftArr.length){
            merged[k++] = leftArr[i++];
        }
        while(j<rightArr.length){
            merged[k++] = rightArr[j++];
        }
        return merged;
    }
}