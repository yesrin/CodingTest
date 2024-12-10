import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0}; // 좌우
    static int[] dy = {0, 0, -1, 1}; // 상하
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 여부 체크
    static int size; // 지도 크기
    static int apartNum = 0; // 단지 수
    static int house = 0; // 단지 내 집 수
    static ArrayList<Integer> houseList = new ArrayList<>(); // 단지 내 집 수 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        map = new int[size][size];
        visited = new boolean[size][size];

        // 지도 입력
        for (int i = 0; i < size; i++) {
            String input = sc.next();
            for (int j = 0; j < size; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        // 단지 탐색
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && map[i][j] == 1) { // 방문하지 않았고 단지의 일부라면
                    house = 0; // 단지 내 집 수 초기화
                    apartNum++; // 단지 수 증가
                    DFS(i, j); // DFS 호출
                    houseList.add(house); // 단지의 집 수 저장
                }
            }
        }

        // 단지 수 출력
        System.out.println(apartNum);

        // 단지 내 집 수 오름차순 출력
        Collections.sort(houseList);
        for (int num : houseList) {
            System.out.println(num);
        }
    }

    static void DFS(int x, int y) {
        visited[x][y] = true; // 방문 처리
        house++; // 현재 단지의 집 수 증가

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            // 지도 범위 내에 있고, 방문하지 않았으며, 단지의 일부라면
            if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
