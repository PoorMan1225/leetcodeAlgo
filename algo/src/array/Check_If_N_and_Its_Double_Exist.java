package array;

import java.util.HashSet;
import java.util.Set;

public class Check_If_N_and_Its_Double_Exist {
    public static void main(String[] args) {
        final boolean b = checkIfExist(new int[]{3, 1, 7, 11});
        System.out.println("b = " + b);
    }

    // 문제 설명
    // 배열이 들어오고 두개의 인덱스가 들어올때 하나의 인덱스의 해당 값을 두배한 값이
    // 배열에 존재하면 true 를 리턴 아니면 false 를 리턴
    // 풀이설명
    // set 에다가 값을 넣고 짝수, 홀수를 구분하여 짝수 일때는 두배한것과 나눈것을 찾고
    // 홀 수 의 경우 두배한것만 찾음.
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (i % 2 == 0) {
                if (set.contains(i * 2) || set.contains(i / 2)) {
                    return true;
                }
            }

            if (i % 2 == 1) {
                if (set.contains(i * 2)) {
                    return true;
                }
            }
            set.add(i);
        }
        return false;
    }

    // 홀수일때 조건 먼저 보게 하고 짝수일때 를 체크하면
    // 하나의 if 문으로 처리가능.
    public static boolean _checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
