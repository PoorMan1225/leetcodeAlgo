package binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_K_Closest_Elements {
    public static void main(String[] args) {
        final List<Integer> result = findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
        System.out.println("result = " + result);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 최소대값을 구하고 거기서 -1을 빼야 최대소값을 구할 수 있다.
        left = arr[left] == x ? left : left - 1;
        int prev = left;
        int next = left + 1;
        List<Integer> result = new ArrayList<>();
        while(prev >= 0 && k > 0 && next < arr.length) {
            if(Math.abs(arr[prev] - x) <= Math.abs(arr[next] - x)) {
                result.add(arr[prev]);
                prev = prev - 1;
            } else {
                result.add(arr[next]);
                next = next + 1;
            }
            k--;
        }
        while(prev >= 0 && k > 0) {
            result.add(arr[prev]);
            prev = prev - 1;
            k--;
        }
        while(next < arr.length && k > 0) {
            result.add(arr[next]);
            next = next + 1;
            k--;
        }
        Collections.sort(result);
        return result;
    }

    public List<Integer> __findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        // 이진 탐색으로 시작점 찾기
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 시작점과 끝점을 비교해서 구간 을 구하는 이진 탐색.. 굉장히 유용할듯!
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 리스트로 변환
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
