package array;


public class Duplicate_Zeros {
    public static void main(String[] args) {
        duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }

    /**
     * 역발상으로 기존의 배열에 clone() 함수로 배열을 shallow copy 후
     * 그 배열을 기준으로 원본 배열에 값을 초기화 하는 방식으로 하는게 더 속도가 빠르다.
     */
    public static void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        int i = 0, j = 0;
        for(; j < arr.length; i++, j++) {
            if(arr[i] != 0) copy[j] = arr[i];
            else {
                copy[j] = arr[i];
                if(j + 1 < arr.length) {
                    copy[j++] = arr[i];
                }
            }
        }
        System.arraycopy(copy, 0, arr, 0, arr.length);
    }
}
