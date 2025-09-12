import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]}); // [0]: 위치, [1]: 중요도
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigher = false;

            for (int[] doc : queue) {
                if (doc[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.add(current); // 뒤로 보내기
            } else {
                count++; // 출력
                if (current[0] == location) return count; // 관심 문서이면 반환
            }
        }

        return count;
    }
}