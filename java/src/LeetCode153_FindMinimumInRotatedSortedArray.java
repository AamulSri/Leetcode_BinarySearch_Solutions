public class LeetCode153_FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
    public static int findMin(int[] nums) {
        int res = findPivot(nums);
        if(res!=-1){
            return nums[res];
        }
        return nums[0];
    }

    private static int findPivot(int[] nums){
        int start =0;
        int end = nums.length -1;

        while(start <=end){
            int mid = start + (end-start)/2;

            if(mid<end && nums[mid]>nums[mid+1]){
                return mid+1;
            }
            if(mid>start && nums[mid]<nums[mid-1]){
                return mid;
            }
            if(nums[start]>=nums[mid]){
                end = mid-1;
            }
            if(nums[start]<nums[mid]){
                start = mid+1;
            }
        }
        return -1;
    }

}
