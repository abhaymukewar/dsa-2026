class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } 
        if(nums.length == 1){
            return nums[0];
        }

        return maxSum(nums, 0, nums.length -1 );      
    }

    public int maxSum(int[] nums, int beg, int end){
        if(beg == end){
            return nums[beg];
        }

        int mid = beg + (end-beg)/2;
        int left = maxSum(nums, beg, mid);
        int right = maxSum(nums, mid+1, end);

        int leftBest = Integer.MIN_VALUE;
        int leftSum = 0;
        for(int i=mid ; i >=beg; i--){
            leftSum += nums[i];
            if(leftBest < leftSum ){
               leftBest = leftSum;
            }
        }
        
        int rightBest = Integer.MIN_VALUE;
        int rightSum = 0;
        for(int i=mid+1; i<=end ; i++){
            rightSum += nums[i];
            if(rightSum > rightBest){
                rightBest = rightSum;
            }
        }

        int crossBest = leftBest + rightBest;

        return max(max(left,right) , crossBest);
    }

    public int max(int i ,int j ){
        if(i > j){
            return i;
        }
        return j;
    }
}
