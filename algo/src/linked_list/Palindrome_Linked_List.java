package linked_list;

public class Palindrome_Linked_List {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        final boolean result = isPalindrome(root);
        System.out.println("result = " + result);
    }

    /**
     * Linked list 에서 들어온 값이 palindrome 인지 비교하는 문제.
     * 처음엔 reverse 후 전체 비교하려고 했는데 공간 복잡도 o(1) 에서 도저히 해결방법이 생각 나질 않았다.
     * 그래서 어쩔 수 없이 반만 reverse 시키고 절반 비교로 코드를 작성했다.
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true; // 값이 한개라면 true
        ListNode prev = null;
        ListNode curr = head;

        // 1. 카운트 개수를 구한다.
        int count = 0;
        ListNode cursor = head;
        while(cursor != null) {
            cursor = cursor.next;
            count++;
        }

        // 2. 반만 reverse 시킨다.
        int i = 0;
        while (i < count / 2) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        // 3. 절반과 절반을 비교한다.
        curr = count % 2 == 0 ? curr : curr.next; // 만약 홀 수라면 중간값은 건너 띄어야 한다.
        while(curr != null) {
            if(curr.val != prev.val) {
                return false;
            }
            curr = curr.next;
            prev = prev.next;
        }
        return true;
    }

    /**
     * 풀이를 보니까 절반 값 을 비교해서 하는데 나처럼 인덱스를 사용하지 않고 노드의 특성을 이용한
     * 중간값 찾기로 reverse 를 시킨다. (난좀 야매인가!?)
     * 아무튼.. 이런 문제는 중간값 을 찾는 알고리즘이나 reverse 같은 걸 알지않고서는 풀 수가 없다.
     */
    public static boolean __isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true; // 값이 한개라면 true

        // 1. 중간 값을 찾는다.
        // fast 와 slow 로 중간값을 찾을 수 있다. (순회하는지 판단도 되고 참 쓸모 있는 알고리즘이다.)
        // fast 는 두칸씩 slow 는 한칸씩 가면 결국 fast 가 완료되는 시점에 slow 는 절반을 간다. (fast / 2 = slow 이므로)
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) { // fast.next 가 null 이 아닌지도 봐야 하는데 왜냐하면 fast.next.next 를 넣을거거든!
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 찾은 중간값 부터 뒤로 reverse 를 시킨다.
        // 왜 뒤냐? 앞이면 안되냐? yes 앞이면 안된다 slow 가 짝수인 경우 정확히 절반을 가리 키는게 아니고 다음 노드를 가리켜 버리기 때문이다.
        // 홀수의 경우 문제는 없다 중간노드 다음 이니깐!
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. reverse 된 값부터 head 와 비교를 한다.
        while (prev != null) {
            if(head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        // 4. 들어온 head 를 원복 해줘야한다! 물론 필요시에만 근데 어떻게 원복하지??
        // 커서 두개가 필요할듯한데? reverse 된 놈을 다시 reverse 하고 붙여주면 될것같다. 그냥 함수로 빼자 변수두개 선언할 바에
        // 함수 선언해서 변수로 쓰자구~
        return true;
    }

    public static void printAllNode(ListNode head) {
        System.out.println("============================");
        while (head != null) {
            System.out.println("head.val = " + head.val);
            head = head.next;
        }
    }
}
