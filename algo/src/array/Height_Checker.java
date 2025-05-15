package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Height_Checker {
    public static void main(String[] args) {

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
        // 뒤에서 부터 반복해야 한다 앞에서 부터 하게 되면
        // count 값이 감소하지 않아서 이상한 위치를 가리킬 수 있게 된다.
        for(int i = heights.length - 1; i >= 0; i--){
            // count[height[2]] 인덱스 정보를 통해서
            // 해당 인덱스와 현재 값이 정확한 위치에 있는지 체크
            // 체크 후에 누적 합 값을 감소시킨다.
            // 감소시키지 않으면 정확한 위치를 찾을 수 없게된다.
            // 왜냐하면 이미 배치된곳에 또 배치될 수 있다 그래서 현재 위치 즉 i 와 배치된 위치가 틀어질 수 있기 때문에
            // 맞는 위치라도 잘못된 위치라고 할 수 도 있다.
            if(heights[--count[heights[i]]] != heights[i]) c++;
        }
        return c;
    }

    /**
     * 이건 인덱스를 사용한 계수정렬이 아닌 Min, Max 를 활용한 계수정렬이다.
     */
    private void countingSort(int[] arr) {
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
            // counts 에 value 값이 0보다 클경우만
            while (counts.getOrDefault(val, 0) > 0) {
                arr[index] = val;
                index += 1;
                counts.put(val, counts.get(val) - 1);
            }
        }
    }

    public int __heightChecker(int[] heights) {
        // Sort the array using counting sort.
        int[] sortedHeights = heights.clone();
        countingSort(sortedHeights);

        int count = 0;
        // Loop through the original and sorted arrays.
        for (int i = 0; i < sortedHeights.length; ++i) {
            // Increment count if elements at the same index differ.
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        // Return the total count of differing elements.
        return count;
    }
}
