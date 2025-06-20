package hash_table;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        while (n != 1) {
            int tmp = n;
            int sum = 0;
            while (tmp > 0) {
                int v = tmp % 10;
                sum += v * v;
                tmp /= 10;
            }
            if(visited.contains(sum)) return false;
            visited.add(sum);
            n = sum;
        }
        return true;
    }
}
