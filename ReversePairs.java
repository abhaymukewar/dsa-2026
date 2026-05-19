class Solution {
    public int reversePairs(int[] nums) {
        int end = nums.length -1;
        int[] tmp = new int[nums.length];
        return merge(nums, 0, end, tmp);
    }

    public int merge(int[] nums, int beg, int end,int[] tmp){
        if(beg >= end){
            return 0;
        }
        int mid = (beg+end) / 2;
        int leftNum = merge(nums,beg,mid, tmp);
        int rightNum = merge(nums,mid+1,end, tmp);

        int currNum =0;
        int i=beg;
        int j=mid+1;
        //System.out.println("Iter: beg:" + beg + " mid:" + mid + " end:" + end);
        while(i <= mid ){
                while(j <= end && (long)nums[i] > (2L* nums[j])) {
                j++;
            } 
            currNum += j - (mid + 1);
            i++;
        }
        
        i= beg;
        j= mid+1;
        int k = beg;
        while(i <= mid && j <=end){
            if(nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while(i <= mid) tmp[k++] = nums[i++];
        while(j <= end) tmp[k++] = nums[j++];

        for (int p = beg; p <= end; p++) {
            nums[p] = tmp[p];
        }

        return currNum + leftNum + rightNum;
    }
}
