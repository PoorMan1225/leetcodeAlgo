package binary_search;

public class First_Bad_Version {
    public static void main(String[] args) {

    }

    // 이진 탐색의 템플릿 1 버전
    // 템플릿 1 은 정확한 값을 찾을 때 보통 사용한다.
    // 보통 범위를 벗어나는 값이 있다면 -1 을 리턴한다. 그래서 사후처리가 필요 없다는 장점이 있다.
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 이진 탐색의 템플릿 2 버전
    // 템플릿 2 는 처음으로 조건을 만족하는 최솟값 인덱스를 찾을 때 보통 사용한다.
    // 그래서 밑에서 후처리를 해줘야 할 경우도 있다.
    public int _firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 오류안나게 넣음 원래 시스템에서 넣어줌
    private boolean isBadVersion(int mid) {
        return false;
    }
}
