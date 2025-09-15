import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            int[] range = Arrays.copyOfRange(array, i - 1, j); // i부터 j까지 슬라이스
            Arrays.sort(range);                                  // 정렬
            answer[idx] = range[k - 1];                          // k번째
        }

        return answer;
    }
}