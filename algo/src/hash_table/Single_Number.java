package hash_table;

import java.util.HashSet;
import java.util.Set;

public class Single_Number {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(set.contains(n)) set.remove(n);
            else {
                set.add(n);
            }
        }
        return set.iterator().next();
    }

    /**
     * xor 연산
     * 같은 숫자가 들어오면 숫자 상쇄
     * ex) 4 1 2 1 2
     * 0 1 0 0 xor 0 0 0 1 -> 0 1 0 1
     * 0 1 0 1 xor 0 0 1 0 -> 0 1 1 1
     * 0 1 1 1 xor 0 0 0 1 -> 0 1 1 0
     * 0 1 1 0 xor 0 0 1 0 -> 0 1 0 0 (4)
     */
    public int _singleNumber(int[] nums) {
        int result=0;
        for(int num:nums){
            result^=num;
        }
        return result;
    }
}
