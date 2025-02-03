import java.util.*;

public class Main {
    public static int[][] box;
    public static int[] dx = {0, 0, 1, -1}; // 좌우
    public static int[] dy = {1, -1, 0, 0}; // 상하
    public static Queue<Tomato> queue = new LinkedList<>();
    public static int M,N;

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로 칸 수
        N = sc.nextInt(); // 세로 칸 수

        box = new int[N][M]; // 박스 크기 초기화

        // 박스에 있는 토마토 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new Tomato(nx, ny, day + 1));
                    }
                }
            }
        }

        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0)
                    return false; // 덜 익은 토마토가 있음
            }
        }
        return true;
    }
}
