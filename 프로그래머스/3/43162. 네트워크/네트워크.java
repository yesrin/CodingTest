import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 방문 여부 체크
        int networkCount = 0; // 네트워크 개수

        // 모든 컴퓨터를 순회
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {          // 아직 방문하지 않은 컴퓨터라면
                dfs(i, computers, visited); // 연결된 컴퓨터 모두 방문
                networkCount++;         // 하나의 네트워크 완성
            }
        }

        return networkCount;
    }

    // DFS 함수
    private void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true; // 현재 컴퓨터 방문 처리

        for (int i = 0; i < computers.length; i++) {
            // 연결되어 있고, 아직 방문하지 않은 컴퓨터라면
            if (computers[current][i] == 1 && !visited[i]) {
                dfs(i, computers, visited); // 재귀 호출로 연결된 컴퓨터 방문
            }
        }
    }
}