package recursion_2;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfs(n, result, sb, 0, 0);
        return result;
    }

    public void dfs(int n, List<String> result, StringBuilder sb, int leftCount, int rightCount) {
        if (rightCount > leftCount) {
            return;
        }
        int len = sb.length();
        if (len == n * 2) {
            result.add(sb.toString());
            return;
        }
        if (leftCount < n) {
            sb.append('(');
            dfs(n, result, sb, leftCount + 1, rightCount);
            sb.setLength(len);
        }
        if (rightCount < n) {
            sb.append(')');
            dfs(n, result, sb, leftCount, rightCount + 1);
            sb.setLength(len);
        }
    }
}
