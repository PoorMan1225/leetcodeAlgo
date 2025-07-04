package binary_search;

public class Find_Smallest_Letter_Greater_Than_Target {
    public static void main(String[] args) {
        nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c');
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(letters[left] <= target) return letters[0];
        else return letters[left];
    }
}
