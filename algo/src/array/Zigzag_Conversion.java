package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zigzag_Conversion {
    public static void main(String[] args) {
        String result = convert("PAYPALISHIRING", 1);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean isDown = true;
        int row = 0;
        for (char c : s.toCharArray()) {
            list.get(row).append(c);
            if(row == 0 || row == numRows - 1) {
                isDown = !isDown;
            }
            row += isDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();
    }
}
