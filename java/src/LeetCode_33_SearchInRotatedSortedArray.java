public class LeetCode_33_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }

        public static int search(int[] nums, int target) {
            int pivot = findPivot(nums);
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

        private static int findPivot(int[] nums){
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
                if(nums[start]>=nums[mid]){
                    end = mid-1;
                }
                if(nums[start]<nums[mid]){
                    start = mid+1;
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

