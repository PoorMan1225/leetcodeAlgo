package hash_table;

import java.util.HashSet;
import java.util.Set;

public class Jewels_and_Stones {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(Character j : jewels.toCharArray()) set.add(j);
        int count = 0;
        for(Character s : stones.toCharArray()) {
            if(set.contains(s)) count++;
        }
        return count;
    }
}
