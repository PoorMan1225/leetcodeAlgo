package binary_search_tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int minHeap;

    public KthLargest(int k, int[] nums) {
        minHeap = k;
        for (int n : nums) {
            pq.add(n);
            // 문제의 조건을 잘 읽고 논리적으로 작성할 필요가 있다.
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > minHeap) {
            pq.poll();
        }
        return pq.peek();
    }
}
