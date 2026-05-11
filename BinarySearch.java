class Solution {
    public int search(int[] nums, int target) {
        if( nums == null || nums.length ==0){
            return -1;
        }
        if(nums.length == 1){
            int idx = nums[0] == target ? 0 : -1;
            return idx;
        }
        return binSearch(nums,0, nums.length-1,target);
    }
    
    public int binSearch(int[] nums, int beg, int end, int target){//3,5
        if(beg >= end){
            int idx = nums[beg] == target ? beg : -1;
            return idx;
        }

        int mid = (beg+end)/2;//2
        
        int left = binSearch(nums, beg, mid, target); //0,2
        int right = binSearch(nums, mid+1, end, target);//3,5
        
        for(int i=beg; i <=end; i++){
            if(nums[i] == target){
                return i;
            }
        }

        if((left == -1) && (right == -1)){
            return -1;
        }
        if(left > 0){
            return left;
        }
        return right;
    }
}
