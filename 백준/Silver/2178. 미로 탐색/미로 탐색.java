import java.util.*;

class Main {
    static int[][] map; // 지도 배열
    static boolean[][] visited; // 방문 여부 배열
    static int[] nearX = {-1, 0, 1, 0}; // 상하좌우 X 이동
    static int[] nearY = {0, 1, 0, -1}; // 상하좌우 Y 이동

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받아 배열 크기 결정
        int x = sc.nextInt(); // 행 크기
        int y = sc.nextInt(); // 열 크기

        // 배열 초기화
        map = new int[x][y];
        visited = new boolean[x][y];

        // 지도 입력
        for (int i = 0; i < x; i++) {
            String input = sc.next();
            for (int j = 0; j < y; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        // BFS 실행
        BFS(0, 0); // 시작 좌표

        // 최단 거리 결과 출력 (목적지 도달 거리)
        int result = map[x - 1][y - 1]; // 목적지 (x-1, y-1)
        System.out.println(result);
    }

    static void BFS(int startX, int startY) {
        // 시작 위치 방문 처리
        visited[startX][startY] = true;

        // 큐 생성 및 초기값 삽입
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 좌표
            int currentX = current[0];
            int currentY = current[1];

            // 현재 위치에서 사방위 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + nearX[i];
                int nextY = currentY + nearY[i];

                // 이동 가능 여부 확인
                if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length 
                    && !visited[nextX][nextY] && map[nextX][nextY] > 0) {
                    
                    // 큐에 삽입 및 방문 처리
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;

                    // 최단 거리 갱신.. 현재 좌표까지의 거리 갱신
                    map[nextX][nextY] = map[currentX][currentY] + 1;
                }
            }
        }
    }
}
