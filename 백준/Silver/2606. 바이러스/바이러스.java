import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int count=0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // 컴퓨터 수
        int M = input.nextInt(); // 연결 수

        // 인접 리스트를 통한 그래프 구성
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결되어 있는 그래프 입력 받기
        for (int i = 0; i < M; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x); // 양방향 그래프
        }

        
        visited = new boolean[N + 1]; 

        // DFS 탐색 시작
        dfs(1);

        // 결과 출력
        System.out.println(count-1);
    }

    // DFS 탐색 메서드
    public static void dfs(int start) {
        visited[start] = true; // 현재 노드 방문 체크
        count++;

        // 연결된 노드 탐색
        for (int next : graph.get(start)) {
            if (!visited[next]) { // 방문하지 않은 노드만 탐색
                dfs(next); // 깊이 증가하며 탐색
            }
        }
    }
}
