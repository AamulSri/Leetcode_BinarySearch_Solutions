public class LeetCode81_SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
    }

    public static boolean search(int[] nums, int target) {
        //not to return index

        int pivot = findPivotInDuplicate(nums);
        if(pivot==-1){
            //not rotated array
            return binarySearch(nums, target , 0, nums.length-1);
        }
        if(nums[pivot]==target){
            return true;
        }
        if(target>=nums[0]){
            // target >=nums[0] so first half search as we have to remember the array is rotated
            return binarySearch(nums, target , 0, pivot-1);
        }
        return binarySearch(nums, target, pivot+1, nums.length -1);
    }

    private static int findPivotInDuplicate(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start <=end){
            int mid = start + ( end-start )/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid> start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[start]==nums[mid] && nums[end]==nums[mid] ){

                if(start < end && nums[start]>nums[start+1]){
                    return start;
                }
                start++;
                if(end > start && nums[end]<nums[end-1]){
                    return end-1;
                }
                end--;

            }
            else if(nums[start]<nums[mid] || nums[start]==nums[mid] && nums[mid]>nums[end]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    private static boolean binarySearch(int[] nums, int target, int start, int end){

        while(start <= end){
            int mid = start + ( end -start )/2;

            if(target == nums[mid]){
                return true;
            }
            else if( target > nums[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
}