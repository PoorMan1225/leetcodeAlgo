package recursion_1;


public class K_th_Symbol_In_Grammer {
    public static void main(String[] args) {
        int result = kthGrammar(3, 3);
        System.out.println(result);
    }

    public static int kthGrammar(int n, int k) {
        String v = recur(1, n, '0');
        if (v.length() - 1 < k) return v.charAt(v.length() - 1) - '0';
        return v.charAt(k - 1) - '0';
    }

    public static String recur(int level, int n, char c) {
        if (n == 1) return "0";
        if (level == n - 1) {
            if (c == '0') return "01";
            else return "10";
        }
        StringBuilder sb = new StringBuilder();
        if (c == '0') {
            sb.append(recur(level + 1, n, '0'));
            sb.append(recur(level + 1, n, '1'));
        } else {
            sb.append(recur(level + 1, n, '1'));
            sb.append(recur(level + 1, n, '0'));
        }
        return sb.toString();
    }

    // n 번째 행의 k 번째 값을 찾기 위해서는 부모즉 n-1 행의 위치 값을 찾아야 한다.
    // 그래서 마지막 번째로 들어가서 위로 찾으면서 가게 되는데
    // 아래에서 위로 그리고 위에서 다시 내려오는 재귀 구조다 .
    // parent 를 찾으면 그 위의 parent 를 또 찾아서 결국 최상위에서 결정되어져서 내려와야
    // 정확한 현재 내가 구하고자 하는 값의 부모를 찾을 수 있게 된다.
    public static int _kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int parent = _kthGrammar(n - 1, (k + 1) / 2);
        boolean isKEven = k % 2 == 0;
        return isKEven ? 1 - parent : parent;
    }
}
