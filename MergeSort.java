class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        if(nums.length ==1){
            return nums;
        }

        return mergeSort(nums, 0,nums.length-1 );
    }

    public int[] mergeSort(int[] nums,int beg, int end)
    {
        if(beg >= end)
        {
            return new int[]{nums[beg]};
        }

        int mid = (beg+end)/2;
        int[] left = mergeSort(nums, beg, mid);
        int[] right = mergeSort(nums, mid+1, end);

        int l=0;
        int r=0;
        int c=0;
        int []retArr = new int[left.length + right.length];
        
        while(l <left.length && r < right.length)
        {
            if(left[l] < right[r])
            {
                retArr[c++] = left[l];
                l++;
            } 
            else 
            {
                retArr[c++] = right[r];
                r++;
            }
        }
        
        while(l <left.length){
            retArr[c] = left[l];
            c++;
            l++;
            
        }
        while(r < right.length){
            retArr[c] = right[r];
            c++;
            r++;
        }
        return retArr;
    }

    private String printArr(int[] arr){
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i < arr.length){
            System.out.println("print i: " + i + " arr[i]:" +arr[i]);
            if(i ==0) {
                sb.append(arr[i]);
            }
            else {
                sb.append(",").append(arr[i]);
            }
            i++;
        }
        return sb.toString();
    }
}
