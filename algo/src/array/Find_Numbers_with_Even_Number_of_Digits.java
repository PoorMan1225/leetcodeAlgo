package array;

public class Find_Numbers_with_Even_Number_of_Digits {
    public static void main(String[] args) {

    }

    public int findNumbers(int[] nums) {
        int result = 0;
        for(int num : nums) {
            if(isDigitsEven(num)) result++;
        }
        return result;
    }

    public boolean isDigitsEven(int num) {
        int count = 0;
        while(num > 0) {
            num = num / 10;
            count++;
        }
        return count % 2 == 0;
    }
}
