class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList();
        }
        int[] counts = new int[nums.length];
        int[] ret = countSmall(nums, 0, nums.length -1, counts);
        
        List<Integer> ans = new ArrayList<>();
        for (int count : counts) {
            ans.add(count);
        }
        return ans;   
    }

    public int[] countSmall(int[] nums, int beg, int end,int[] counts){//{1,0}{3,2}
        if(beg >= end){
            return new int[]{beg};
        }
        int mid = (beg + end)/2;
        int[] retListLeft = countSmall(nums,beg, mid, counts);
        int[] retListRight = countSmall(nums,mid+1, end, counts);
        //printArr("Left:", retListLeft);
        //printArr("Right:",retListRight);
        int[] ret = new int[retListLeft.length + retListRight.length];

        int l = 0;int r = 0;
        int retIdx = 0;
        int rightSmallerCount = 0;                              // 0 1   0 1
        while(l < retListLeft.length && r < retListRight.length)//{2,5} {1,6}
        {
            if( nums[retListLeft[l]] > nums[retListRight[r]] ) // 2>1, 2>6 ,5>6 
            {
                rightSmallerCount++;//1
                ret[retIdx++] = retListRight[r];//{1}
                r++; //1
            } else {
                int leftOriginalIndex = retListLeft[l];//1,0
                counts[leftOriginalIndex] = counts[leftOriginalIndex] + rightSmallerCount;//2,1,0,0
                ret[retIdx++] = retListLeft[l]; //{1,2}- {1,2,0} 
                //rightSmallerCount = 0; //
                l++; // 1,2
            }   
        }
        while( l < retListLeft.length )
        { 
            if(rightSmallerCount > 0){
                int leftOriginalIndex = retListLeft[l];
                counts[leftOriginalIndex] = counts[leftOriginalIndex] + rightSmallerCount;
                //rightSmallerCount = 0;
            }
            ret[retIdx++] = retListLeft[l++];
        }
        while( r < retListRight.length )
        {
            ret[retIdx++] = retListRight[r++];
        }
        //printArr("All:" , ret);
        //printArr("Count: " , counts);
        return ret;
    }

    public void printArr(String pre,int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i: arr){
            sb.append(i).append(",");
        }
        String ret = sb.toString();
        String p = pre + ret.substring(0,ret.length()-1);
        System.out.println(p);
    }
}
