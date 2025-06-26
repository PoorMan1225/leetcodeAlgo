package hash_table;

import java.util.HashMap;

public class Four_Sum_2 {
    public static void main(String[] args) {

    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // HashMap 을 두개를 만든다. 
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        // 비교군을 두개로 만들기 위해서 더한다.
        for (Integer n1 : nums1) {
            for (Integer n2 : nums2) {
                map1.put(n1 + n2, map1.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        for (Integer n3 : nums3) {
            for (Integer n4 : nums4) {
                map2.put(n3 + n4, map2.getOrDefault(n3 + n4, 0) + 1);
            }
        }
        int target = 0;
        int count = 0;
        for (Integer key : map1.keySet()) {
            // 모든 경우의 수를 구해줘야 한다.
            if (map2.containsKey(target - key)) {
                count += map1.get(key) * map2.get(target - key);
            }
        }
        return count;
    }

    /**
     *  이렇게도 되네!? 난 바보입니까?
     */
    public int _fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int k:nums3) {
            for (int l:nums4) {
                map.put((k+l), map.getOrDefault((k+l), 0) + 1);
            }
        }
        int c=0;
        for (int i:nums1){
            for (int j:nums2){
                c+=map.getOrDefault(-(i+j),0);

            }
        }
        return c;
    }
}
