import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) {
        // 1. 인접 리스트 만들기
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 2. BFS 준비
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1); 
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;

        // 3. BFS 실행
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        // 4. 가장 큰 거리 찾기
        int maxDist = 0;
        for (int d : dist) {
            if (d > maxDist) maxDist = d;
        }

        // 5. 그 거리와 같은 노드 개수 세기
        int count = 0;
        for (int d : dist) {
            if (d == maxDist) count++;
        }

        return count;
    }

    // 테스트용
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 6;
        int[][] vertex = {
            {3,6}, {4,3}, {3,2},
            {1,3}, {1,2}, {2,4}, {5,2}
        };
        System.out.println(sol.solution(n, vertex)); // 결과: 3
    }
}