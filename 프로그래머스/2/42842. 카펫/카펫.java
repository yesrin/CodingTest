import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 가운데 노란색 세로 길이 후보를 1부터 yellow까지 시도
        for (int h = 1; h <= yellow; h++) {
            if (yellow % h != 0) continue; // 가로가 정수가 아니면 건너뛰기
            
            int w = yellow / h + 2; // 노란색 가로 + 양쪽 갈색 테두리
            int totalH = h + 2;     // 노란색 세로 + 위아래 갈색 테두리
            
            // 전체 타일 수가 brown+yellow와 같으면 조건 만족
            if (w * totalH == brown + yellow) {
                return new int[]{w, totalH}; // [가로, 세로] 반환
            }
        }
        
        return new int[]{};
    }
}