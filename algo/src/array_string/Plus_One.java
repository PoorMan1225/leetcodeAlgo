package array_string;

import java.util.Arrays;

public class Plus_One {
    public static void main(String[] args) {
        __plusOne(new int[]{9});
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 1; i--) {
            if (digits[i] >= 10) {
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            } else {
                break;
            }
        }
        int[] array = new int[digits.length + 1];
        if (digits[0] >= 10) {
            // 원본 테이블의 0번 인덱스 부터 시작하여 복사할 대상 테이블의 1번부터 복사시작.
            digits[0] = 0;
            System.arraycopy(digits, 0, array, 1, digits.length - 1);
            array[0] = 1;
            return array;
        }
        return digits;
    }

    /**
     * 사실 여기서 자릿수의 경우는 만약 한자리수씩 올리다가 중간에 끊긴다면 그냥 digits 을 리턴하면 되고
     * 그게 아니라 끝까지 가게 되는 경우는 자리수들이 모두 99999 이런 형태로 이루어져 있기 때문에
     * 전부 0으로 변경하고 그다음에 첫번째 자리 와 두번째 자리만 1,0 으로 변경 시켜주면 된다.
     */
    public static int[] __plusOne(int[] digits) {
        int arrLength = digits.length;
        for (int i = arrLength - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum == 10) {
                digits[i] = 0;
            } else {
                digits[i] = sum;
                break;
            }
        }

        if (digits[0] == 0) {
            digits = new int[arrLength + 1];
            digits[0] = 1;
            digits[1] = 0;
        }
        return digits;

    }
}
