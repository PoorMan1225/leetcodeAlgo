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
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown; // 방향 전환
            }
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
