package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Height_Checker {
    public static void main(String[] args) {
        countingSort(new int[]{1,1,4,2,1,3});
    }

    // 문제 설명
    // 정수 배열이 주어지고 키순으로 주어진다. 키순으로 주어지지 않았을때
    // 키순으로 정렬한후 일치하지 않는 인덱스의 개수를 반환한다.
    //
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int count = 0;
        for(int i=0; i<heights.length; i++) {
            if(heights[i] != copy[i]) count++;
        }
        return count;
    }

    /**
     * 계수정렬 사용
     * 누적합을 사용해서 구하지만 누적합의 제한인 배열 때문에 일반적으로 사용하기 힘든 단점이 있다.
     * 하지만 인덱스를 구하는 부분이 다른 곳에서도 적용하기 좋으므로 활용하기 좋다.
     */
    public int _heightChecker(int[] heights) {
        // count 배열 생성
        int[] count = new int[101];

        // 키의 값으로 인덱스에 해당키가 위치하는 좌표를 지정
        for(int i = 0; i < heights.length; i++){
            count[heights[i]] += 1;
        }
        // 누적합을 해서 범위 를 지정
        // ex) [1,1,4,2,1,3]
        // count [0,3,1,1,1,0]
        // 누적합 [0,3,4,5,6,6]
        // 해석 : height[2] = 4 라면
        // count[height[2]] 4값이 위치해야 할 인덱스 정보
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        int c = 0; // 카운트 변수
        for(int i = heights.length - 1; i >= 0; i--){
            // count[heights[i]] 는 순서대로라고 가정할때
            // 자기 포함해서 자기 뒤에 개수가 몇개 있다 이렇게 생각할 수 있다.
            // 그래서 배치를 하고 같은 숫자면 자리를 감소시켜서 재배치를 해야 하기 때문에 -- 로 감소시키고 그리고 인덱스를 찾으려면
            // 숫자에서 하나를 감소시켜야 하기때문에 -- 가 필요하다.
            if(heights[--count[heights[i]]] != heights[i]) c++;
        }
        return c;
    }

    /**
     * 이건 인덱스를 사용한 계수정렬이 아닌 Min, Max 를 활용한 계수정렬이다.
     */
    private static void countingSort(int[] arr) {
        // Map 을 만든다.
        Map<Integer, Integer> counts = new HashMap<>();
        // 최대값 최소값을 찾는다.
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // 각 요소들의 count 값을 넣는다. (계수를 넣는다.)
        for (int val : arr) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        int index = 0;
        // minValue 를 초기화 하고 maxValue 까지 value 를 증가시킨다.
        for (int val = minVal; val <= maxVal; ++val) {
            // value 값이 6이라면 6의 카운트 개수만큼 index 를 증가시켜서 추가한다.
            while (counts.getOrDefault(val, 0) > 0) {
                arr[index] = val;
                index += 1;
                counts.put(val, counts.get(val) - 1);
            }
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    /**
     * 이 코드는 leet code 에서 가장 추천을 많이 받은 코드다.
     */
    public int __heightChecker(int[] heights) {
        // 제한 배열을 지정한다.
        int[] heightToFreq = new int[101];

        // 카운트를 증가시킨다.
        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        // 정렬을 한후 비교하는 것을 nlogn 의 정렬을 사용하지 않고
        // 카운팅 소트를 사용후 비교하고 있다.
        for (int i = 0; i < heights.length; i++) {
            // 가장 큰 숫자 까지 curHeight 을 증가시키면서
            // 만약 값이 없다면 curHeight 을 증가시키다가 값이 있으면
            // 여기서 숫자를 증가 시키는것은 1 1 1 2 이런 상황이면 3 1 이렇게 카운팅이 되니까 결국 curHeight 인덱스가 각 자리가 된다.
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            // 가장 작은 값을 찾앗으므로 비교한다.
            // 여기서는 같지 않으면(자기 자리가 아니므로) 결과를 올린다.
            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }

        return result;
    }
}
