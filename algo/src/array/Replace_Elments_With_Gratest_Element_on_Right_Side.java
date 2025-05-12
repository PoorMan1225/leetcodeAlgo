package array;

import java.util.*;

public class Replace_Elments_With_Gratest_Element_on_Right_Side {
    public static void main(String[] args) {
//        final int[] result = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        final int[] result = _replaceElements(new int[]{4, 0, 0});
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    /**
     * 문제 설명
     * 현재 내 인덱스보다 큰값으로 오른쪽을 채우는 문제 값이 0일 경우 채우지 않아야 한다.
     * o(n) 으로 풀고 싶었으나 이중 포문을 최소화 하기 위해서 max 값이 필요할때만 찾는 위주로
     * 풀었음. 최악의 경우 o(n^2)
     * @return
     */
    public static int[] replaceElements(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int maxValue = findMax(0, arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == maxValue) {
                maxValue = findMax(i + 1, arr);
            }
            if (maxValue > 0) result.add(maxValue);
        }
        result.add(-1);
        int[] copy = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            copy[i] = result.get(i);
        }
        return copy;
    }

    public static int findMax(int start, int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    /**
     * 앞에서 부터 큰값을 배치해야 한다면 앞에서 부터 뒤에 값들 중에서 가장 큰값을
     * 하나의 요소마다 반복해서 찾아야만 한다. 하지만 뒤에서 부터 찾게 되면
     * 초기 값을 -1 을 max 값으로 두고 현재 값에서 오른쪽으로 가장 큰값은 -1 이 되고
     *
     * input : [17, 18, 5, 4, 6, 1]
     * 6 -> 1
     * 4 -> 6
     * 5 -> 6
     * ...
     * feed) 현재 인덱스에서 방법을 찾는게 쉽지 않다면 뒤에서부터 생각을 해보자.
     *
     */
    public static int[] _replaceElements(int[] arr) {
        int maxRight = -1;
        int length = arr.length;

        for (int index = length - 1; index >= 0; index--) {
            int current = arr[index];
            arr[index] = maxRight;
            maxRight = Math.max(maxRight, current);
        }

        return arr;
    }
}
