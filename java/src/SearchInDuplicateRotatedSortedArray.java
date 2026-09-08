public class SearchInDuplicateRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {6,6,6,6,7,7,0,1,6};
        System.out.println(search(arr, 1));
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivotInDuplicate(nums);
        int end = nums.length-1;
        if(pivot ==-1){
            return binarySearch(nums,target , 0 ,nums.length-1);
        }
        else if(nums[pivot] == target){
            return pivot;
        }
        else if(target>=nums[0]){
            return binarySearch(nums,target , 0 ,pivot-1);
        }
        return binarySearch(nums,target ,pivot+1 ,nums.length-1);

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

    private static int binarySearch(int[] nums , int target , int start , int end ){
        while(start <=end ){
            int mid = start + (end- start)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

}
