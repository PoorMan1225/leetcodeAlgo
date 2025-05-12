package array;


public class Valid_Mountain_Array {
    public static void main(String[] args) {
        validMountainArray(new int[]{0, 3, 2, 1});
    }

    /***
     * 문제 설명
     * 배열의 숫자가 산의 형태를 이루고 있는지 체크하는 함수를 반환. (산의 형태는 연속되는 수가 나와서는 안된다.)
     *
     * 제한사항
     * 1 <= arr.length <= 10^4
     * 이중 포문으로 풀면 시간제한에 걸릴 것임 . 최소한 nLogn
     */
    public static boolean validMountainArray(int[] arr) {
        int idx = -1;
        // 1. 봉우리를 먼저 찾아보자.
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                idx = i;
                break;
            }
        }
        // 2. 봉우리를 못찾았다면 false
        if (idx < 0) return false;

        // 3. 봉우리를 찾고 찾은 봉우리부터 점점 우하향인지 혹은 우상향인지 체크
        int left = idx - 1;
        int right = idx + 1;
        while (left >= 0) {
            if (arr[left] >= arr[left + 1]) return false;
            left--;
        }
        while (right <= arr.length - 1) {
            if (arr[right] >= arr[right - 1]) return false;
            right++;
        }
        return true;
    }

    /**
     * 와 이건 진짜 생각 자체를 못했는데
     * 1. 배열의 크기가 3보다 작으면 증가 수열 자체를 못만드니 false
     * 2. 배열을 오른쪽으로 증가시켜본다 작아지는 구간이 있으면 멈추고 없으면 증가 수열이므로 false
     * 3. 배열이 작아지는 구간에서 계속 작아지는지 체크 계속작아지다가 커지면 false 아니면 true
     *      (true 체크는 길이로)
     *  둘다 o(n). 이지만 아래 코드가 더 효율적이다. 그치만 내가 코드를 잘 못읽는건지 읽기가 어렵네
     *
     *  feed) index 를 찾는데서 잔실수가 너무 많은데 +1, -1 를 명확하게 할 필요가 있음.
     */
    public static boolean _validMountainArray(int[] arr) {
        int i = 0;
        if (arr.length < 3) {
            return false;
        }
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i >= arr.length - 1) {
            return false;
        }
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        return (i == arr.length - 1);
    }
}
