import java.util.*;

public class Main {
    public static int[][] map;
    public static int maxCount = 0;
    public static int x;
    public static int y;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        map = new int[x][y]; // 배열 초기화

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = sc.nextInt(); // 입력받기
            }
        }

        // 빈 공간들의 좌표를 emptySpaces에 저장
        List<int[]> emptySpaces = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }

        // 벽 3개를 세울 수 있는 모든 조합을 찾고
        // 각 조합에 대해 안전 영역을 계산
        selectWalls(emptySpaces, 0, new int[3], 0);
        System.out.println(maxCount);
    }

    // 벽을 세울 3개의 공간을 고르는 함수
    public static void selectWalls(List<int[]> emptySpaces, int startIdx, int[] selected, int depth) {
        if (depth == 3) { // 벽을 3개 선택한 경우
            // 벽을 세운 맵에서 안전 영역 계산
            for (int i = 0; i < 3; i++) {
                int[] pos = emptySpaces.get(selected[i]);
                map[pos[0]][pos[1]] = 1; // 벽을 세운다
            }

            // 안전 영역 계산 후 최대값 갱신
            maxCount = Math.max(maxCount, getSafeZone());

            // 벽을 다시 원래대로 돌려놓는다
            for (int i = 0; i < 3; i++) {
                int[] pos = emptySpaces.get(selected[i]);
                map[pos[0]][pos[1]] = 0;
            }
            return;
        }

        for (int i = startIdx; i < emptySpaces.size(); i++) {
            selected[depth] = i; // 현재 인덱스를 선택
            selectWalls(emptySpaces, i + 1, selected, depth + 1); // 다음 벽을 선택
        }
    }

    // 안전 영역을 계산하는 함수
    public static int getSafeZone() {
        int[][] tempMap = new int[x][y];  // 맵 복사본 만들기
        for (int i = 0; i < x; i++) {
            tempMap[i] = map[i].clone();  // 배열 복사
        }

        // BFS를 이용해 바이러스 퍼뜨리기
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (tempMap[i][j] == 2) {  // 바이러스(2) 위치 찾기
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0], col = pos[1]; // x, y 꺼내기

            for (int d = 0; d < 4; d++) {
                int nx = row + dx[d];
                int ny = col + dy[d];

                if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                    if (tempMap[nx][ny] == 0) {  // 빈 칸이면 바이러스 확산
                        tempMap[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 안전 영역(0의 개수) 계산
        int safeZone = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (tempMap[i][j] == 0) safeZone++;
            }
        }
        return safeZone;
    }
}
