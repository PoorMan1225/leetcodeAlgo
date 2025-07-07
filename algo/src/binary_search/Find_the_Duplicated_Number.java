package binary_search;

public class Find_the_Duplicated_Number {
    public static void main(String[] args) {

    }

    /**
     * 이진 탐색 카운터 방식. (파라매트릭 서치)
     * 이방식은 1 ~ n 까지 값의 범위에 존재하고 중복된 숫자하나를 제외 하고 나머지 숫자는
     * 하나의 값을 가진다고 가정했을때 의미가 있다.
     * <p>
     * 왜냐하면 어떤수가 임의로 배열 되어 있다면 ex) 4 3 2 1 5 3
     * 이 숫자의 범위 1 ~ 5 까지일때 임의의 중간값을 설정 했을때
     * ex) 2 라면 2 이하의 숫자를 세었을때 총 개수가 2개를 넘을 수 없을 것이다. 왜냐하면 중복된 숫자가 하나가 존재하고
     * 중복되지 않은 숫자는 하나의 값만 가지므로 중복되지 않았다면 2이하의 숫자의 개수는 최대 2개가 될 것이다.
     * 중복된 숫자가 포함되어 있을 경우 최대숫자 2 보다 숫자가 클 것이므로 이경우 mid + 1 로 카운트를 다시 찾아서 체크해주면 된다.
     * <p>
     * 여기서 중요한 포인트는 배열의 순서는 아무런 의미가 없고 그범위를 벗어나서 큰틀 즉 목표에 맞게 생각해야 한다는 것이다.
     * 그러니까 배열은 그저 숫자를 세는 도구에 불과하고 진짜 값의 범위는 1 ~ n 사이의 이진 탐색으로 값을 찾아내기만 된다는 것이다.
     */
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int n : nums) {
                if(mid >= n) count++;
            }
            // 이부분이 핵심이다.
            // 문제의 포인트를 핵심을 읽는 능력을 키워야 한다.
            if(mid < count) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     *  fast - slow 알고리즘
     *  이 방식은 문제 구조 틀 자체를 아예 다르게 생각을 해서 돌다리로 생각을 해야 한다.
     *  ex) 4 3 2 1 5 3
     *  4 -> 5 -> 3 -> 1 -> 3 -> 1 ... 이런식으로 순환 구조가 생기게 된다.
     *  그래서 순환구조를 표현하는 num의 값을 가지고 오면 되는데 o(n) 으로 가지고 올 수 있다는 좋은 장점이 있다.
     *
     */
    public int __findDuplicate(int[] nums) {
        // 순환구조가 존재하는지 확인.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        // 순환구조는 무조건 존재 하기 때문에 순환하는 위치를 찾아야 한다.
        // 위치를 찾는 법은 수학 공식을 이용해서 찾으면 되는데
        // L + x = K * C 공식을 이용해서
        // L = (K * C) / x 를 활용하면 된다. 자세한 내용은 문서 참조.
        // 순환 위치 찾기.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            // fast 도 한칸씩 앞으로 전진한다.
            fast = nums[fast];
        }
        // 이때 만나는지점 slow 가 위치가 된다.
        return slow;
    }
}
