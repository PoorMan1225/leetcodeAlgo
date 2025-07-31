package recursion_2;

public class Quick_Sort {
    public static void main(String[] args) {
        quickSort(new int[]{1, 5, 3, 2, 8, 7, 6, 4});
    }

    public static void quickSort(int[] lst) {
        /* Sorts an array in the ascending order in O(n log n) time */
        int n = lst.length;
        qSort(lst, 0, n - 1);
    }

    private static void qSort(int[] lst, int lo, int hi) {
        if (lo < hi) {
            int p = partition(lst, lo, hi);
            qSort(lst, lo, p - 1);
            qSort(lst, p + 1, hi);
        }
    }

    private static int partition(int[] lst, int lo, int hi) {
    /*
      pivot 위치를 고정시키고 나머지를 또 정렬시키면서 재귀적으로 또 고정시키고 반복 하는 방식
     */
        int pivot = lst[hi]; // pivot 위치 맨 끝
        int i = lo;         // 시작인덱스
        for (int j = lo; j < hi; ++j) { // pivot 제외 끝까지
            if (lst[j] < pivot) {     // pivot 보다 크다면 계속 진행
                int tmp = lst[i];    // 교환할
                lst[i] = lst[j];        // pivot 시작값과
                lst[j] = tmp;
                i++;
            }
        }
        int tmp = lst[i];
        lst[i] = lst[hi];
        lst[hi] = tmp;
        return i;
    }
}
