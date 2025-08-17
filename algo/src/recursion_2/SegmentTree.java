package recursion_2;
public class SegmentTree {

    static int[] tree;
    static int[] arr;

    public static void main(String[] args) {
        // 원본 배열
        arr = new int[]{2, 5, 1, 4, 9, 3};
        int n = arr.length;

        // 세그먼트 트리 크기 (안전하게 4 * n 할당)
        tree = new int[4 * n];

        SegmentTree seg = new SegmentTree();
        seg.build(1, 0, n - 1);

        // 전체 트리 출력
        System.out.println("세그먼트 트리:");
        for (int i = 1; i < 2 * n; i++) {
            System.out.printf("node %d: %d\n", i, tree[i]);
        }

        // 구간 합 예시: [1, 4]
        int sum = seg.query(1, 0, n - 1, 1, 4);
        System.out.println("\n구간 [1,4] 합: " + sum); // 5 + 1 + 4 + 9 = 19

        // 값 변경 예시: arr[2] = 7 로 변경
        seg.update(1, 0, n - 1, 2, 7);
        sum = seg.query(1, 0, n - 1, 1, 4);
        System.out.println("업데이트 후 구간 [1,4] 합: " + sum); // 5 + 7 + 4 + 9 = 25
    }

    // 세그먼트 트리 빌드
    // 구간 합을 구해야 하는 경우 세그먼트 트리를 사용해야 한다.
    // 구간을 빠르게 구할 수 있는 방법은 세그먼트 트리의 경우 log n 이기 때문에 자주 계산해야 되는경우에
    // 매우 빠르게 계산할 수 있다.
    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(node * 2, start, mid); // 왼쪽 구간합 계산
            build(node * 2 + 1, mid + 1, end); // 오른쪽 구간합 계산
            tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 전체 구간합 계산
        }
    }

    // 구간 합 질의
    int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0; // 겹치지 않음
        }
        if (left <= start && end <= right) {
            return tree[node]; // 완전히 포함
        }
        int mid = (start + end) / 2;
        int lSum = query(node * 2, start, mid, left, right);
        int rSum = query(node * 2 + 1, mid + 1, end, left, right);
        return lSum + rSum;
    }

    // 값 변경
    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(node * 2, start, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}
