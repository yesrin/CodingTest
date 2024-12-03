import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> Graph; // 그래프를 저장할 인접 리스트
    static int pointNum;  // 노드 개수
    static int lineNum;   // 간선 개수
    static int[] visitOrder; // 방문 순서를 저장할 배열
    static int order = 1;    // 방문 순서를 기록할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pointNum = sc.nextInt(); // 노드 개수 입력
        lineNum = sc.nextInt();  // 간선 개수 입력
        int startPoint = sc.nextInt(); // 시작 정점 입력

        // 그래프 초기화
        Graph = new ArrayList<>();
        for (int i = 0; i <= pointNum; i++) {
            Graph.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i = 0; i < lineNum; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph.get(u).add(v); // 정점 u에 v를 추가
            Graph.get(v).add(u); // 정점 v에 u를 추가 (양방향)
        }

        // 각 정점의 연결 리스트를 정렬 (정점 번호가 작은 순서대로 방문)
        for (int i = 1; i <= pointNum; i++) {
            Collections.sort(Graph.get(i));
        }

        // 방문 순서를 기록할 배열 초기화
        visitOrder = new int[pointNum + 1];

        // DFS 실행
        boolean[] visited = new boolean[pointNum + 1]; // 방문 여부를 체크할 배열
        dfs(startPoint, visited);

        // 방문 순서 출력
        for (int i = 1; i <= pointNum; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    public static void dfs(int node, boolean[] visited) {
        visited[node] = true; // 현재 정점 방문 처리
        visitOrder[node] = order++; // 방문 순서 기록

        // 현재 정점과 연결된 모든 정점 탐색
        for (int next : Graph.get(node)) {
            if (!visited[next]) { // 방문하지 않은 정점만 탐색
                dfs(next, visited); // 재귀 호출
            }
        }
    }
}
