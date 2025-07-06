package array;

public class 행개수_열개수 {
    public static void main(String[] args) {
        int[][] calendar = new int[6][7];
        int offset = 2;  // 예: 1일이 수요일부터 시작
        for (int day = 1; day <= 31; day++) {
            int idx = day + offset - 1;  // 실제 위치 조정
            int i = idx / 7;             // row (주) 행과, 컬럼의 변경은 모두 컬럼기준으로 이루어진다. 막대를 생각해보면 됨.
            int j = idx % 7;             // column (요일)
            calendar[i][j] = day;
        }
        printCalendar(calendar);
    }

    private static void printCalendar(int[][] calendar) {
        System.out.println("============= CALENDAR START ==============");
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                System.out.printf("%3d", calendar[i][j]);
            }
            System.out.println();
        }
        System.out.println("============= CALENDAR END ==============");
    }
}
