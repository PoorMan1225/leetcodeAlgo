package array;

public class Move_Zeroes {
    public static void main(String[] args) {

    }

    /**
     * 문제 설명
     * 배열이 주어지고 0이 아닌 요소의 상대적 순서를 유지하면서
     * 모든 값을 배열의 끝으로 이동해야 한다.
     * <p>
     * 앞에서 배운 towPointer 를 사용해서 해결해볼 것이다.
     */
    public void moveZeroes(int[] nums) {
        // 쓰기 인덱스 설정
        int writeIndex = 0;
        // 최초 0의 인덱스를 먼저 찾는다.
        for (writeIndex = 0; writeIndex < nums.length; writeIndex++) {
            if (nums[writeIndex] == 0) break;
        }
        // 마지막 까지 가면 return
        if (writeIndex >= nums.length) return;

        // 그게 아닐경우 찾은 0인덱스 다음 부터 자리를 옮긴다.
        // 옮긴 자리는 다시 0으로 초기화 해준다.
        for (int readIndex = writeIndex + 1; readIndex < nums.length; readIndex++) {
            if(nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                nums[readIndex] = 0;
                writeIndex++;
            }
        }
    }

    /**
     * 먼저 인덱스를 찾아놓고 그자리부터 옮기는게 아니라.
     * 먼저 옮긴 다음에 마지막 찾은 index 부터 뒤를 0으로 채운다.
     */
    public static void _moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            // i가 0값이 아니면
            if(nums[i]!=0){
                // index 자리에다가 i를 넣는다.
                nums[index++] = nums[i];
            }
        }
        // 그다음 index 부터 뒷자리를 0으로 채운다.
        for(int i=index;i<nums.length;i++){
            nums[i] = 0;
        }
    }
}
