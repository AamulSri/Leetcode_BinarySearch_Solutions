public class Strivers_LC540_SingleElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
    public static int singleNonDuplicate(int[] nums) {
        int start = 1;
        int n = nums.length;
        int end = n-2;

        if(n==1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }

        while(start<=end){
            int mid = start + (end - start)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if((mid%2==1 && nums[mid]==nums[mid-1]) ||(mid%2==0 && nums[mid]==nums[mid+1])){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }


}
