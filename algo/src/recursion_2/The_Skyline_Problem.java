package recursion_2;


import java.util.ArrayList;
import java.util.List;

public class The_Skyline_Problem {
    public static void main(String[] args) {

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        return null;
    }

    public List<List<Integer>> recursion(int start, int end, int[][] buildings) {
        // 하나가 남은 건물의 좌표를 구한다.
        if(start >= end) {
            int[] building = buildings[start];
            List<List<Integer>> list = new ArrayList<>();
//            list.add(building[0], building[2]);
            return list;
        }

        // 두 그룹의 좌표를 하나로 만들어서 해당 좌표를 건내준다.
        return null;
    }
}
