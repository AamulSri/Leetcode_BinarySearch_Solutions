public class LeetCode_1095_FindInMountainArray {

    public static void main(String[] args) {

        System.out.println(findInMountainArray(2, new int[]{0, 1, 2, 4, 2, 1}));

    }

   /*
   We are using length and compare variables to
    reduce the calls on mountainArr
    as that's a requirement of question
    */
    public static int findInMountainArray(int target, int[] mountainArr) {

        int length = mountainArr.length -1;
        int max_index = findMaxElementIndex(mountainArr, length);

        int index_min = agnosticBS(0, max_index, target, mountainArr);

        if (index_min != -1) {
            return index_min;
        }

        return agnosticBS(max_index+1, mountainArr.length - 1, target, mountainArr);

    }

    public static int findMaxElementIndex(int[] mountainArr,int end) {
        int start = 0;

        while (start != end) {
            int mid = start + (end - start) / 2;
            int compare = mountainArr[mid];
            if (compare > mountainArr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int agnosticBS(int start, int end, int target, int[] mountainArr) {
        boolean isAsc = mountainArr[start] < mountainArr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int compare = mountainArr[mid];
            if (target == compare) {
                return mid;
            }
            if (isAsc) {
                if (target < compare) {
                    end = mid - 1;
                } else if (target > compare) {
                    start = mid + 1;
                }
            } else {
                if (target < compare) {
                    start = mid + 1;
                } else if (target > compare) {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

}
