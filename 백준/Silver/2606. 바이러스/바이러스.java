import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // 컴퓨터 수
        int M = input.nextInt(); // 연결 수

        // 인접 리스트를 통한 그래프 구성
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결된 그래프 입력 받기
        for (int i = 0; i < M; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x); // 양방향 그래프
        }

        visited = new boolean[N + 1];

        // BFS 탐색 시작
        bfs(1);

        // 결과 출력
        System.out.println(count - 1);
    }

    // BFS 탐색 메서드
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 시작 노드를 큐에 추가
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 큐에서 하나의 노드를 꺼냄
            count++;

            // 현재 노드와 연결된 노드들을 확인
            for (int next : graph.get(current)) {
                if (!visited[next]) { // 방문하지 않은 노드라면
                    visited[next] = true; // 방문 체크
                    queue.offer(next); // 큐에 추가
                }
            }
        }
    }
}
