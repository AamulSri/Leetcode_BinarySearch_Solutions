public class LeetCode_744_SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char res = nextGreatestLetter(new char[]{'c','f','j'}, 'c');
        System.out.println(res);
    }


    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(letters[mid]<=target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return letters[start%letters.length];
    }
}