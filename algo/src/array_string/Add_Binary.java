package array_string;

public class Add_Binary {
    public static void main(String[] args) {
        final String result = addBinary("1", "111");
        System.out.println("result = " + result);
    }

    /**
     * 문제설명
     * 두 개의 이진 문자열이 주어지면 그 합을 이진 문자열로 반환한다.
     */
    public static String addBinary(String a, String b) {
        int bigIndex = Math.max(a.length() - 1, b.length() - 1);
        int smallIndex = Math.min(a.length() - 1, b.length() - 1);
        int[] arr = new int[Math.max(a.length(), b.length()) + 1];
        StringBuilder sb = new StringBuilder();

        while (smallIndex >= 0) {
            int v1 = a.charAt(a.length() > b.length() ? bigIndex : smallIndex) - 48;
            int v2 = b.charAt(a.length() > b.length() ? smallIndex : bigIndex) - 48;
            int checkValue = v1 + v2 + arr[bigIndex + 1];
            appendValue(bigIndex, arr, sb, checkValue);
            smallIndex--;
            bigIndex--;
        }

        while (bigIndex >= 0) {
            int v1 = arr[bigIndex + 1];
            int v2 = (a.length() > b.length() ? a.charAt(bigIndex) : b.charAt(bigIndex)) - 48;
            int checkValue = v1 + v2;
            appendValue(bigIndex, arr, sb, checkValue);
            bigIndex--;
        }
        if (arr[0] >= 1) sb.append("1");
        return sb.reverse().toString();
    }

    private static void appendValue(int bigIndex, int[] arr, StringBuilder sb, int checkValue) {
        switch (checkValue) {
            case 2: {
                arr[bigIndex]++;
                sb.append("0");
                break;
            }
            case 3: {
                arr[bigIndex]++;
                sb.append("1");
                break;
            }
            case 1:
                sb.append("1");
                break;
            case 0:
                sb.append("0");
                break;
            default:
                break;
        }
    }

    public String __addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }

}
